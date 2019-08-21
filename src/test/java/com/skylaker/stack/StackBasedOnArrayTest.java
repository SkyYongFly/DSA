package com.skylaker.stack;

import org.junit.jupiter.api.Test;

/**
 * 基于数组栈测试
 * @author skylaker2019@163.com
 * @version V1.0 2019/8/21 11:43 PM
 */
public class StackBasedOnArrayTest {
    @Test
    public void testStack(){
        StackBasedOnArray stack = new StackBasedOnArray(5);

        // 先入栈
        String[] arr = {"23", "3", "56", "78", "12"};
        for(String str : arr){
            stack.push(str);
        }

        // 再出栈
        for(int i = 0; i < 5; i++){
            System.out.print(stack.pop() + " ");
        }

        System.out.println();

        // 再出栈，就都是null了，因为上一步都弹出了元素
        for(int i = 0; i < 5; i++){
            System.out.print(stack.pop() + " ");
        }
    }
}
