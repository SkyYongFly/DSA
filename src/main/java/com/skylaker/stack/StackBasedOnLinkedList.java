package com.skylaker.stack;

/**
 * 基于链表实现的栈
 * @author skylaker2019@163.com
 * @version V1.0 2019/8/22 12:03 AM
 */
public class StackBasedOnLinkedList {
    // 栈顶结点，该结点也就可直接代表栈
    Node<String> top = null;

    /**
     * 入栈操作
     * @param val
     */
    public void push(String val){
        Node newNode = new Node(val, null);

        if(null == top){
            top = newNode;
        } else {
            // 新的结点成为栈顶元素
            newNode.next = top;
            top = newNode;
        }
    }

    /**
     * 出栈操作
     */
    public String pop(){
        if(null == top){
            return null;
        }

        String val = top.data;
        // 新的栈顶元素后移一个结点
        top = top.next;
        return val;
    }

    /**
     * 获取所有结点值
     */
    public void printAll(){
        if(null == top){
            System.out.println("[空结构]");
        }

        Node p = top;
        while (p != null){
            System.out.print(p.getData() + " ");
            p = p.next;
        }
        System.out.println();
    }


    public static class Node <E> {
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
}
