package com.skylaker.string;

/**
 * Trie树前缀匹配查找字符串 （默认字符串字符集为26个小写字母）
 * @author skylaker
 * @version V1.0 2020/5/19 20:44
 */
public class Trie {
    // Trie 树的根节点，字符内容默认空
    private TrieNode root = new TrieNode();

    /**
     * 新增字符串
     * @param str
     */
    public void insertString(String str){
        if(null == str || "".equals(str)) {
            return;
        }

        char[] chars = str.toCharArray();

        // 当前字符位置指针
        TrieNode p = root;

        for(int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if(null == p.childNodes[index]) {
                // 父节点的子节点数组中没有当前字符指针
                TrieNode childNode = new TrieNode(chars[i]);
                if(i == chars.length - 1) {
                    childNode.setEndChar(true);
                }

                p.childNodes[index] = childNode;
            }
            // 当前节点指针移动到下一个字符位置
            p = p.childNodes[index];
        }
    }

    /**
     * 新增字符串 优化结尾设置
     * @param str
     */
    public void insertString2(String str){
        if(null == str || "".equals(str)) {
            return;
        }

        char[] chars = str.toCharArray();
        // 当前字符位置指针
        TrieNode p = root;

        for(char c : chars) {
            int index = c - 'a';
            if(null == p.childNodes[index]) {
                // 父节点的子节点数组中没有当前字符指针
                p.childNodes[index] = new TrieNode(c);
            }
            // 当前节点指针移动到下一个字符位置
            p = p.childNodes[index];
        }

        // 遍历完字符串，p 指向的就是结尾字符位置
        p.setEndChar(true);
    }

    /**
     * 判断某个字符串是否存在当前集合中
     */
    public boolean isExistStr(String str){
        if(null == str || "".equals(str)) {
            return false;
        }

        char[] chars = str.toCharArray();

        // 从根节点依次遍历
        TrieNode p = root;
        for(char c : chars) {
            if(null == p.childNodes[c - 'a']) {
                return false;
            }
            p = p.childNodes[c - 'a'];
        }

        // p 如果最终指向结束字符，那么当前字符串就存在，否则不存在
        if(p.isEndChar) {
            return true;
        }
        return false;
    }


    /**
     * Trie树节点
     */
    public class TrieNode {
        // 当前节点的字符数据
        private char data;

        // 指向子节点的指针数组
        // 子节点的字符是哪个，就在对应索引位置指向子节点
        private TrieNode[] childNodes = new TrieNode[26];

        // 当前节点是否是某个字符串的结尾字符
        private boolean isEndChar = false;

        public TrieNode() { }

        public TrieNode(char data) {
            this.data = data;
        }

        public void setEndChar(boolean endChar){
            this.isEndChar = endChar;
        }
    }
}
