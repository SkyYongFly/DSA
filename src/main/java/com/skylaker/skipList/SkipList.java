package com.skylaker.skipList;

import javax.management.MXBean;
import java.util.Random;

/**
 * 跳表实现 (原链表为单链表，且存储元素值为自然数)
 * @author skylaker
 * @version V1.0 2019/12/14 22:17
 */
public class SkipList {
    // 定义最大层高，之所以设置为32，因为按照两个元素一个索引节点的话，可以满足最大 2^32 链表构建跳表
    private static final int MAX_LEVEL = 32;

    // 实际跳表高度，即为最大索引层高度，第一层为0，最高层为 realLevel - 1
    private int realLevel = 0;

    // 头节点，虚拟的哨兵节点，为了方便后续遍历，直接高度设置为最大层高（如果设置尾节点的话，也是同样如此）
    private Node head = new Node(-1, MAX_LEVEL);

    // 随机算法，用于生成层高数
    private Random random = new Random(100);


    /**
     * 查找跳表中是否存在指定元素值的节点
     * @param value 需要查找的元素值
     * @return {Node} 目标节点（肯定是原链表即第一层的节点了，如果只是判断是否存在并不需要一定遍历到第一层，因为索引层对应节点值为目标值就代表元素值存在了）
     */
    public Node search(int value){
        // 当前查找节点，从头节点开始
        Node current = head;

        /**
         *  从最顶层头节点开始查找，查找目标元素的前一个节点
         *  例如
         *
         *  3层   HEAD                            78      TAIL
         *  2层   HEAD            21              78      TAIL
         *  1层   HEAD     5      21      57      78      TAIL
         *  0层   HEAD  2  5  16  21  32  57  62  78  99  TAIL
         *
         *  例如查找元素32，首先从最顶层HEAD元素开始，即3层中的HEAD ，它判断下一个节点值即78与目标元素大小关系，发现大于，所以跳出内层while循环，下沉一层；
         *  到下一层即2层查找，发现21比32小，所以在内层while循环中当前查找节点后移一位到21，在继续比较下一位，发现78大于，所以目标元素肯定在21和78之间，下沉一层；
         *  到下一层即1层查找，类似，找到21和57区间，继续在21索引位置下沉一层；
         *  到下一层即0层查找，当前查找节点即是0层的21，比较下一个节点值是否比32小，发现不，所以跳出内层while循环，而外层高度已经到0，即已经找到目标元素在0层应该存放位置的前一个节点；
         */
        for(int level = realLevel - 1; level >= 0 ; level--){
            // 内层循环找到当前层比目标元素小的节点，即目标元素应该所在位置前一个节点
            while (null != current.nextNodes[level] && current.nextNodes[level].data < value){
                current = current.nextNodes[level];
            }
        }

        // 因为目标值肯定在最终的查找节点和后一个节点之间，即 (current, current.next] ，
        // 而查找节点是比目标元素小的，所以肯定不是，那就直接比较下个节点值是否等于目标元素值
        if(null != current.nextNodes[0] && value == current.nextNodes[0].data){
            return current.nextNodes[0];
        } else {
            // 如果下个节点值不等于目标值，那么说明目标节点是在查找节点和下个节点之间的 (current, current.next) ，即不存在
            // 同样还要考虑一种场景，例如查找元素100，最终的查找节点就是0层的99节点，判断到后继节点为空，而目标元素节点又在99后面，那只能说明不不存在
            return null;
        }
    }


    /**
     * 插入元素
     * @param value 新增元素值
     */
    public void insert(int value){
        // 首先获取新增节点占用几层，即原链表本身节点+索引层节点
        // 采用随机算法，确保得到的层数在最大层限制之内
        // 当时需要考虑一种特殊情况，即初始跳表为空，这个时候新增的元素为第一个元素，无需建立索引层
        int level = null == head.nextNodes[0] ? 1 : getRandomLevel();

        if(level > realLevel){
            // 如果超过当前层高，只设置层高为实际层高+1 ，避免单个节点过分高，影响查找效率
            level = ++realLevel;
        }

        // 例如当前层高 10， 计算得到的层高为 6 ，那么层高就是 6 ；但是如果计算出来是 20，则层高设置为 21；

        // 新建节点
        Node newNode = new Node(value, level);

        // 新建节点的所有前置节点值数组，因为单链表的插入需要找到前驱节点，需要这里需要找到目标节点各个层的前置节点
        Node[] preNodes = new Node[level];
        for(int i = 0; i < level; i++){
            // 初始前置节点都设置为头节点
            preNodes[i] = head;
        }

        //找到目标节点各个层的前置节点
        Node current = head;
        for(int currentLevel = level; currentLevel >= 0; currentLevel--){
            while (null != current.nextNodes[currentLevel] && current.nextNodes[currentLevel].data < value){
                current = current.nextNodes[currentLevel];
            }

            preNodes[currentLevel] = current;
        }

        // 在每一层插入目标节点
        for(int i = 0; i < level; i++){
            newNode.nextNodes[i] = preNodes[i].nextNodes[i];
            preNodes[i].nextNodes[i] = newNode;
        }
    }

    /**
     * 获取随机层数，在最大层高限制内取一值
     * @return
     */
    private int getRandomLevel(){
        int level = 1;

        for(int i = 0; i < MAX_LEVEL; i++){
            if(random.nextInt() / 2 == 0){
                level++;
            }
        }
        return level;
    }


    /**
     * 跳表节点定义
     * 这里的节点并不仅仅是普通链表中的节点概念，而是代表节点在整个跳表中的所有位置集合，
     * 即包括当前节点值以及所有后继节点索引
     */
    public class Node {
        // 当前节点的元素值，默认-1
        private int data = -1;

        // 代表当前节点的所有后继节点索引
        // nextNodes[0]代表当前节点在第1层的后继节点指针
        // 数组大小即为当前节点最大高度
        private Node[] nextNodes;

        // 当前节点最大高度
        // 包括原链表本身节点以及索引层节点
        private int maxLevel = 0;

        /**
         * 构造一个level层高的节点元素，其实指定多高即代表当前元素在哪几层存在
         * @param data 节点值
         * @param level 层高
         */
        public Node(int data, int level){
            this.data = data;

            // 当前节点值在每一层其实都是一样的，只是后继节点是不一样的，而后继节点元素数量正是层高
            this.nextNodes = new Node[level];
        }
    }
}
