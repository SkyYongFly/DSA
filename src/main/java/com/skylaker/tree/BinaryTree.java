package com.skylaker.tree;

import org.junit.jupiter.api.Test;

/**
 * 二叉树
 * @author skylaker
 * @version V1.0 2020/1/2 21:37
 */
public class BinaryTree {
    /**
     * 前序遍历
     * @param root
     */
    public static void preOrder(Node root){
        if(null == root) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void inOrder(Node root){
        if(null == root) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    /**
     * 后序遍历
     * @param root
     */
    public static void postOrder(Node root){
        if(null == root) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
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
    }

    @Test
    public void testOrder() {
        int[] data = {3, 12, 1, 35, 6, 21, 89, 55, 78};

        //            3
        //          /   \
        //       12      1
        //      /  \      \
        //    35    6       21
        //      \          /  \
        //       89      55    78
        Node root = new Node(3);
        Node node2 = new Node(12);
        Node node3 = new Node(1);
        Node node4 = new Node(35);
        Node node5 = new Node(6);
        Node node6 = new Node(21);
        Node node7 = new Node(89);
        Node node8 = new Node(55);
        Node node9 = new Node(78);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node4.right = node7;
        node6.left = node8;
        node6.right = node9;

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }
}
