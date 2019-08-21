package com.skylaker.linkedlist;

/**
 * 链表操作
 * @author skylaker2019@163.com
 * @version V1.0 2019/8/21 9:37 PM
 */
public class LinkedListUtil{
    /**
     * 根据指定数组生成单链表
     */
    public static Node createLinkedList(int[] arr){
        if(null == arr || 0 == arr.length){
            return null;
        }

        Node head = new Node(arr[0], null);
        Node p = head;
        for(int i = 1; i < arr.length; i++){
            Node node = new Node(arr[i], null);
            p.next = node;
            p = node;
        }
        return head;
    }


    /**
     * 打印指定链表
     */
    public static void printAllByHead(Node h){
        if(null == h){
            System.out.println("[无数据]");
        }

        Node p = h;
        while (null != p){
            System.out.print(p.getData() + " ");
            p = p.next;
        }
        System.out.println();
    }

    /**
     * 单链表反转：核心思想依次遍历在头结点之前插入后续结点
     *
     * null、  A   、 B   、 C 、 D 、 E
     * A   、  null、 B   、 C 、 D 、 E
     * B   、  A   、 null、 C 、 D 、 E
     *
     * @param list 链表（即头结点）
     */
    public static Node reverse(Node list){
        // 当前结点，一开始是实际头结点
        Node cur = list;
        // 哨兵头结点,一直指向第一个节点
        Node pre = null;

        while (cur != null){
            // 先缓存后继结点，避免当前结点反转后无法找到后继结点
            Node next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 链表中环的检测：核心思想 设置两个快慢指针，快指针一次走两步，满指针一次走一步，如果存在环，那么不然快慢指针会重合
     *
     * @param list 链表（即头结点）
     */
    public static boolean isHasCircle(Node list){
        if(null == list){
            return false;
        }

        Node fast = list.next;
        Node slow = list;

        // 如果 next 为空必然是有尾结点链表，则也就无环
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    /**
     * 将两个有序单链表合并（这里设置从小到大）
     *
     * 方案1：一个链表不动，另一个链表从头到尾依次往里插入到合适位置
     * 方案2：利用哨兵节点，从前到后依次寻找较小数 ，像针穿线一样串起来，例如
     *
     *      2 10 23 45 67
     *   p
     *      5  9 18 76 89 99 102
     *
     * @param list1
     * @param list2
     * @return
     */
    public static Node mergeTwoList(Node<Integer> list1, Node<Integer> list2){
        // 这里用第二种方案

        Node s = new Node(null, null);
        Node p = s;

        while (list1 != null && list2 != null){
            if(list1.getData().intValue() < list2.getData().intValue()){
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            // 不要忘了首指针动态变化
            p = p.next;
        }

        // 两个链表长度不一定相等，只要一个链表遍历结束，那么剩下的链表尾部分必然比之前所有结点值大
        if(null != list1){
            p.next = list1;
        }

        if(null != list2){
            p.next = list2;
        }

        // 真正的头结点是哨兵后继结点
        return s.next;
    }

    /**
     * 删除单链表倒数第k个结点
     *
     * 方案1：直接遍历整个链表获取链表长度n，那么 m = n - k + 1 即为正数第 m 个元素，再遍历删除
     * 方案2：先设置一个快指针，走k步，那么此时首结点相对快指针指向结点就是倒数第k个结点，
     *      此时设置慢指针指向首结点，快慢指针都往后走，快指针走到尾结点，那么慢指针正好就是倒数第k个元素
     */
    public static Node deleteLastKNode(Node list, int k){
        // 这里实现方案2

        if(null == list || k < 0){
            return null;
        }

        Node fast = list;
        int num = 1;
        while (fast != null && num < k){
            fast = fast.next;
            num++;
        }

        if(fast == null){
            // 说明 k 的值大于整个链表长度
            return list;
        }

        Node slow = list;
        Node pre = null;
        while (fast.next != null){
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        if(pre == null){
            // 说明要删除的是头结点、
            list = list.next;
        } else {
            pre.next = pre.next.next;
        }

        return list;
    }

    /**
     * 寻找链表中间结点（对于偶数个结点，中间左右两边结点都可以，其实找到左边的，右边自然也就找到了）
     *
     * 思想：设置快慢指针，快指针一次两步，慢指针一次一步，快指针到尾或者没有后继指针，则慢指针就在中间结点
     */
    public static Node getMiddleNode(Node list){
        if(null == list){
            return null;
        }

        Node fast = list;
        Node slow = list;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
