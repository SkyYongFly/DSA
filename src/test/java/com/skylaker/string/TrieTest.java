package com.skylaker.string;

import org.junit.jupiter.api.Test;

/**
 * @author skylaker
 * @version V1.0 2020/5/19 21:12
 */
public class TrieTest {
    @Test
    public void testTrieInsert(){
        Trie trie = new Trie();
        trie.insertString2("hello");
        trie.insertString2("her");
        trie.insertString2("hi");
        trie.insertString2("why");

        System.out.println(trie.isExistStr("hello"));
        System.out.println(trie.isExistStr("her"));
        System.out.println(trie.isExistStr("hi"));
        System.out.println(trie.isExistStr("h"));
        System.out.println(trie.isExistStr("herd"));
        System.out.println(trie.isExistStr("who"));
        System.out.println(trie.isExistStr("wh"));
        System.out.println(trie.isExistStr("whoh"));
    }
}
