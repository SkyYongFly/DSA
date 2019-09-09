package com.skylaker.queue;

/**
 * 链式队列
 * @author skylaker2019@163.com
 * @version V1.0 2019/9/9 11:17 PM
 */
public class LinkedQueue {
    // 队头
    private Node head = null;
    // 队尾
    private Node tail = null;

    /**
     * 入队
     * @param item
     * @return
     */
    public void enqueue(String item){
        Node node = new Node(item, null);
        if(tail == null){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    /**
     * 出队
     * @return
     */
    public String dequeue(){
        if(null == head){
            return null;
        }
        String item = head.data;
        head = head.next;

        // 考虑边界情况，如果当期head指向最后一个元素，即和tail位置一样，那么再出队，则head指向下一个结点即空，tail也就自然指向空了
        if(null == head){
            tail = null;
        }
        return item;
    }

    /**
     * 输出元素
     */
    public void print(){
        Node p = head;
        while(null != p){
            System.out.print(p.data + " ");
            p = p.next;
        }
    }


    /**
     * 链式队列结点定义
     */
    public class Node {
        private String data;

        private Node next;

        Node(String data, Node next){
            this.data = data;
            this.next = next;
        }
    }
}
