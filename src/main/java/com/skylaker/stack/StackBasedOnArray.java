package com.skylaker.stack;

/**
 * 基于数组的栈
 * @author skylaker2019@163.com
 * @version V1.0 2019/8/21 11:14 PM
 */
public class StackBasedOnArray {
    // 内部维护一个数组结构
    private String[] arr;
    // 栈最大大小，即数组的设置大小
    private int max;
    // 栈中已有元素个数
    private int num;

    /**
     * 初始化栈，即初始化内部的数组
     * @param max
     */
    public StackBasedOnArray(int max){
        this.arr = new String[max];
        this.max = max;
        this.num = 0;
    }

    /**
     * 入栈操作
     * @return 成功：true ；失败：false
     */
    public boolean push(String item){
        if(num == max){
            // 已有元素个数达到最大数量限制，则说明栈已经满
            return false;
        }

        arr[num] = item;
        num++;

        return true;
    }

    /**
     * 出栈操作
     */
    public String pop(){
        if(0 == num){
            // 已有元素个数为0则说明栈是空的
            return null;
        }

        // 从最上面取值
        String item = arr[num-1];
        num--;

        return item;
    }
}

