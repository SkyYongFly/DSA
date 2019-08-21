package com.skylaker.stack;

import org.junit.jupiter.api.Test;

/**
 * 基于链表实现的栈测试
 * @author skylaker2019@163.com
 * @version V1.0 2019/8/22 12:15 AM
 */
public class StackBasedOnLinkedListTest {
    @Test
    public void testStack(){
        StackBasedOnLinkedList stack = new StackBasedOnLinkedList();

        // 入栈
        String[] arr = {"23", "3", "56", "78", "12"};
        for(String str : arr){
            stack.push(str);
        }

        // 获取所有元素
        stack.printAll();

        // 出栈，栈顶元素
        System.out.println("栈顶元素：" + stack.pop());
    }
}
