package com.skylaker.tree;

import org.junit.jupiter.api.Test;

/**
 * 二叉查找树
 * @author skylaker
 * @version V1.0 2020/1/2 22:10
 */
public class BinarySearchTree {
    private Node root;

    /**
     * 查找指定值的节点（默认无重复元素）
     * @param data 目标节点值
     * @return {Node} 目标节点
     */
    public Node findNode(int data){
        // 查找游标节点
        Node p = root;
        while (null != p){
            if(data < p.data) {
                p = p.left;
            } else if(data > p.data){
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    /**
     * 插入指定值的节点
     * @param data 目标节点值
     */
    public void insertNode(int data){
        if(null == root){
            root = new Node(data);
            return;
        }

        // 查找游标节点
        Node p = root;
        while (null != p){
            if(data < p.data) {
                if(null == p.left){
                    Node node = new Node(data);
                    p.left = node;
                    return;
                }
                p = p.left;
            } else {
                if(null == p.right){
                    Node node = new Node(data);
                    p.right = node;
                    return;
                }
                p = p.right;
            }
        }
    }

    /**
     * 树节点
     */
    public class Node {
        private int data;

        private Node left;

        private Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public void inOrder(Node root){
        if(null == root) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    @Test
    public void test(){
        //            13
        //          /   \
        //       10      15
        //      /  \      \
        //    5    11       21
        //      \          /  \
        //       7      18    25
        
        root = new Node(13);
        Node node2 = new Node(10);
        Node node3 = new Node(15);
        Node node4 = new Node(5);
        Node node5 = new Node(11);
        Node node6 = new Node(21);
        Node node7 = new Node(7);
        Node node8 = new Node(18);
        Node node9 = new Node(15);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node4.right = node7;
        node6.left = node8;
        node6.right = node9;

        System.out.println(findNode(18));
        System.out.println(findNode(21));
        System.out.println(findNode(5));

        insertNode(12);
        inOrder(root);
    }
}
