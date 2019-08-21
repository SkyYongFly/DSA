package com.skylaker.linkedlist;

/**
 * 单链表结点
 * @author skylaker2019@163.com
 * @version V1.0 2019/8/21 9:38 PM
 */
public class Node <E> {
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
