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
     * 删除指定值的节点
     * @param data 目标节点值
     */
    public void deleteNode(int data){
        // 首先查找节点
        /// p代表当前查找节点位置，最终为要删除的节点
        /// pp代表p节点的父节点
        Node p = root;
        Node pp = null;
        while (null != p){
            if(data == p.data){
                break;
            } else if(data < p.data){
                pp = p;
                p = p.left;
            } else {
                pp = p;
                p = p.right;
            }
        }

        if(null == p){
            System.out.println("未找到指定值的树节点");
            return;
        }

        // 对有两个子节点的节点先进行处理
        if(null != p.left && null != p.right){
            // 从右子树中查找最小值的节点
            Node m = p;
            p = p.right;
            while(null != p.left){
                pp = p;
                p = p.left;
            }
            m.data = p.data;
        }

        // 最终的p节点只有一个节点或者没有子节点
        // 找出子节点的子节点
        Node child ;
        if(null != p.left){
            child = p.left;
        } else if(null != p.right){
            child = p.right;
        } else {
            child = null;
        }

        // 删除最终节点
        if(null == pp){
            // 树只有一个根节点且删除的就是根节点
            p = null;
        } else if(pp.left == p){
            pp.left = child;
        } else if(pp.right == p){
            pp.right = child;
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
        Node node9 = new Node(25);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node4.right = node7;
        node6.left = node8;
        node6.right = node9;

        inOrder(root);
        System.out.println();

        System.out.println(findNode(18));
        System.out.println(findNode(21));
        System.out.println(findNode(5));

        insertNode(12);
        //            13
        //          /   \
        //       10      15
        //      /  \      \
        //    5    11       21
        //      \    \      /  \
        //       7    12  18    25
        inOrder(root);

        System.out.println();

        deleteNode(10);
        //            13
        //          /   \
        //       11      15
        //      /  \      \
        //    5     12      21
        //      \          /  \
        //       7      18    25
        inOrder(root);
    }
}
