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
    private Node findNodeByValue(String value){
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
     * 查找第k个结点
     */
    private Node findNodeByIndex(int index){
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
