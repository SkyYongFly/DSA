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
        Node node = list.findNodeByIndex(3);
        list.insertAfter(node, new Node("100", null));
        list.printAll();

        // 在第三个元素之前插入新元素
        Node node3 = list.findNodeByIndex(3);
        list.insertBefore(node3, new Node("92", null));
        list.printAll();

        // 删除第三个元素（先找到节点，再删除）
        Node nodeD = list.findNodeByIndex(3);
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

    @Test
    public void testReverse(){
        String[] arr2 = {"86", "5", "20", "43", "13", "67"};
        SinglyLinkedList list2 = new SinglyLinkedList();
        for(String str : arr2){
            list2.insertAfterTailOfVal(str);
        }
        list2.printAll();

        // 单链表反转
        LinkedListUtil.printAllByHead(LinkedListUtil.reverse(list2.getHead()));
    }

    @Test
    public void testCircle(){
        String[] arr2 = {"5", "20", "43", "13", "67"};
        Node head = new Node("86", null);
        Node p = head;
        for(String str : arr2){
            Node node = new Node(str, null);
            p.next = node;
            p = node;
        }
        LinkedListUtil.printAllByHead(head);

        System.out.println("是否存在环：" + LinkedListUtil.isHasCircle(head));

        // 设置环
        p.next = head;
        System.out.println("是否存在环：" + LinkedListUtil.isHasCircle(head));
    }

    @Test
    public void testMerge(){
        int[] arr1 = {2, 13, 35, 49, 57};
        Node list1 = LinkedListUtil.createLinkedList(arr1);

        int[] arr2 = {5, 23, 26, 36, 51, 67, 93};
        Node list2 = LinkedListUtil.createLinkedList(arr2);

        LinkedListUtil.printAllByHead(LinkedListUtil.mergeTwoList(list1, list2));
    }

    @Test
    public void testDelete() {
        int[] arr1 = {29, 13, 3, 49, 57};
        Node list1 = LinkedListUtil.createLinkedList(arr1);

        LinkedListUtil.printAllByHead(LinkedListUtil.deleteLastKNode(list1, 2));
    }

    @Test
    public void testMiddleNode() {
        int[] arr1 = {29, 13, 3, 49, 57, 32,2};
        Node list1 = LinkedListUtil.createLinkedList(arr1);

        System.out.println(LinkedListUtil.getMiddleNode(list1).getData());
    }

}
