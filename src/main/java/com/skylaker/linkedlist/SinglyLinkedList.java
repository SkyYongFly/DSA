package com.skylaker.linkedlist;

/**
 * 单链表实现
 *
 * @author skylaker2019@163.com
 * @version V1.0 2019/8/17 11:13 PM
 */
public class SinglyLinkedList {
    /**
     * 链表结点定义
     */
    static class Node<E> {
        // 结点保存对象
        E data;
        // 后继节点
        Node<E> next;

        Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }

        E getData(){
            return this.data;
        }
    }

    /**
     * 定义链表头节点，这里定义当前链表保存的值都是字符串
     */
    private Node<String> head = null;

    /**
     * 查找指定值的节点
     */
    public Node findNodeByValue(String value){
        if(isStrNullOrEmpty(value)){
            return null;
        }

        // 从头节点依次遍历
        Node p = head;
        while (null != p && !p.data.equals(value)){
            p = p.next;
        }
        // 要么找到返回结点；要么遍历完没找到，返回空
        return p;
    }

    /**
     * 查找指定值的int节点是索引（默认头结点对应0）
     */
    public int findNodeIndexByValue(String value){
        if(isStrNullOrEmpty(value)){
            return -1;
        }

        // 从头节点依次遍历
        Node p = head;
        int index = 0;
        while (null != p && !p.data.equals(value)){
            p = p.next;
            index++;
        }

        if(null == p){
            return -1;
        }
        return index;
    }

    /**
     * 查找第k个结点
     */
    public Node findNodeByIndex(int index){
        if(index < 1){
            return null;
        }

        Node p = head;
        // 代表当前遍历到第几个结点
        int point = 1;
        while (null != p && index != point){
            p = p.next;
            point++;
        }
        return p;
    }

    /**
     * 在头节点之前插入结点(当前链表为非带头节点)
     */
    public void insertBeforeHead(Node newNode){
        if(null == newNode){
            return;
        }

        if(null == head){
            head = newNode;
        } else {
            // 新插入的结点就是头节点，原有头节点变成新节点的后继结点
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * 在头结点之前插入指定值的结点
     */
    public void insertBeforeHeadOfVal(String val){
        if(isStrNullOrEmpty(val)){
            return;
        }

        Node<String> newNode = new Node<String>(val, null);
        insertBeforeHead(newNode);
    }

    /**
     * 在链表尾部插入新结点
     */
    public void insertAfterTail(Node newNode){
        if(null == newNode){
            return;
        }

        if(null == head){
            head = newNode;
        } else {
            // 需要依次遍历链表找到尾节点
            Node p = head;
            while (null != p.next){
                p = p.next;
            }

            // p.next为空，表明当前p结点就是尾节点
            p.next = newNode;
            // 当前新结点作为尾节点
            newNode.next = null;
        }
    }

    /**
     * 在链表尾部插入指定值新结点
     */
    public void insertAfterTailOfVal(String val){
        if(isStrNullOrEmpty(val)){
            return;
        }

        Node newNode = new Node(val, null);
        insertAfterTail(newNode);
    }

    /**
     * 在指定结点之后插入新结点
     */
    public void insertAfter(Node p, Node newNode){
        if(null == p || null == newNode){
            return;
        }

        // 一定要注意指针指向顺序
        newNode.next = p.next;
        p.next = newNode;
    }

    /**
     * 在指定结点之前插入新结点
     */
    public void insertBefore(Node p, Node newNode){
        if(null == p || null == newNode){
            return;
        }

        if(p == head){
            // 如果指定结点就是头节点，那么直接新结点就是头结点了
            insertBeforeHead(newNode);
        } else {
            // 关键在于顺序找到指定结点的前一个结点
            Node q = head;
            while (null != q && q.next != p){
                q = q.next;
            }

            if(null == q) {
                return;
            }

            newNode.next = q.next;
            q.next = newNode;
        }
    }

    /**
     * 在指定结点之前插入指定值结点
     */
    public void insertBeforeOfVal(Node p, String val){
        Node newNode = new Node(val, null);
        insertBefore(p, newNode);
    }

    /**
     * 删除指定结点
     */
    public void deleteNode(Node p){
        if(null == p || null == head){
            return;
        }

        if(p == head){
            head = null;
        } else {
            Node q = head;
            while (null != q && q.next != p){
                q = q.next;
            }

            if(null == q){
                return;
            }

            q.next = q.next.next;
        }
    }

    /**
     * 删除第k个结点(头结点对应第1个)
     */
    public void deleteNodeByIndex(int index){
        if(index < 1 || null == head){
            return;
        }

        if(1 == index){
            head = head.next;
            return;
        }

        Node p = head;
        int pos = 2;
        while (null != p && pos != index){
            p = p.next;
            pos++;
        }

        p.next = p.next.next;
    }


    /**
     * 删除指定值的（第一个）结点
     */
    public void deleteNodeByVal(String val){
        if(isStrNullOrEmpty(val) || null == head){
            return;
        }

        if(val.equals(head.getData())){
            head = head.next;
            return;
        }

        Node p = head;
        while (null != p && !p.next.getData().equals(val)){
            p = p.next;
        }

        if(null == p){
            return;
        }

        p.next = p.next.next;
    }

    /**
     * 删除指定值的所有结点
     */
    public void deleteAllNodeByVal(String val){
        if(isStrNullOrEmpty(val) || null == head){
            return;
        }

        // 构造哨兵节点
        Node<String> p = new Node(null, head);
        Node<String> q = p;
        while (null != q && null != q.next){
            if(q.next.getData().equals(val)){
                q.next = q.next.next;
                continue;
            }
            q = q.next;
        }
        // 重置头结点
        head = p.next;
    }

    /**
     * 打印所有结点值
     */
    public void printAll(){
        if(null == head){
            System.out.println("[无数据]");
        }

        Node p = head;
        while (null != p){
            System.out.print(p.getData() + " ");
            p = p.next;
        }
        System.out.println();
    }


    /**
     * 判断字符串是否为空
     * @param str 字符串对象
     * @return true 空； false 非空
     */
    private boolean isStrNullOrEmpty(String str){
        if(null == str || "".equals(str)){
            return true;
        }
        return false;
    }
}
