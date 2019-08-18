package com.skylaker.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * 单链表测试
 * @author skylaker2019@163.com
 * @version V1.0 2019/8/18 10:42 AM
 */
public class SinglyLinkedListTest {
    @Test
    public void testLinkedList(){
        String[] arr = {"11", "13", "8", "20", "99", "32"};

        // 初始化创建链表（通过尾部插入元素）
        SinglyLinkedList list = new SinglyLinkedList();
        for(String str : arr){
            list.insertAfterTailOfVal(str);
        }
        list.printAll();

        System.out.println("元素11在链表中位置：" + list.findNodeIndexByValue("11"));
        System.out.println("元素8在链表中位置：" + list.findNodeIndexByValue("8"));
        System.out.println("元素7在链表中位置：" + list.findNodeIndexByValue("7"));

        System.out.println("第3个元素值：" + list.findNodeByIndex(3).getData());

        // 头结点之前插入新元素
        list.insertBeforeHeadOfVal("78");
        list.printAll();

        // 尾节点后插入新元素
        list.insertAfterTailOfVal("66");
        list.printAll();

        // 在第三个元素之后插入新元素
        SinglyLinkedList.Node node = list.findNodeByIndex(3);
        list.insertAfter(node, new SinglyLinkedList.Node("100", null));
        list.printAll();

        // 在第三个元素之前插入新元素
        SinglyLinkedList.Node node3 = list.findNodeByIndex(3);
        list.insertBefore(node3, new SinglyLinkedList.Node("92", null));
        list.printAll();

        // 删除第三个元素（先找到节点，再删除）
        SinglyLinkedList.Node nodeD = list.findNodeByIndex(3);
        list.deleteNode(nodeD);
        list.printAll();

        // 删除第三个元素 (直接根据索引顺序)
        list.deleteNodeByIndex(3);
        list.printAll();

        // 新增一个重复值结点
        list.insertAfterTailOfVal("20");
        list.printAll();

        // 删除指定值得第一个元素
        list.deleteNodeByVal("20");
        list.printAll();


        System.out.println();

        // 初始化创建链表（通过尾部插入元素）
        String[] arr2 = {"13", "13", "2", "13", "13", "13"};
        SinglyLinkedList list2 = new SinglyLinkedList();
        for(String str : arr2){
            list2.insertAfterTailOfVal(str);
        }
        list2.printAll();

        // 删除指定值得所有结点
        list2.deleteAllNodeByVal("13");
        list2.printAll();
    }
}
