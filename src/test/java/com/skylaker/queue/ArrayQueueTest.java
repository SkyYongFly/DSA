package com.skylaker.queue;

import org.junit.jupiter.api.Test;

/**
 * @author skylaker2019@163.com
 * @version V1.0 2019/9/9 10:18 PM
 */
public class ArrayQueueTest {
    @Test
    public void testQueue(){
        String[] items = {"13", "2", "78", "32", "99", "67"};

        // 入队
        ArrayQueue arrayQueue = new ArrayQueue(items.length);
        for(String item : items){
            arrayQueue.enqueue(item);
        }
        // 测试队列已经满了再插入元素
        System.out.println(arrayQueue.enqueue("3"));

        // 出队
        for(int i = 0; i < items.length; i++){
            System.out.print(arrayQueue.dequeue() + " ");
        }
        // 测试队列空情况下出队
        System.out.println("\n" + arrayQueue.dequeue());
    }
}
