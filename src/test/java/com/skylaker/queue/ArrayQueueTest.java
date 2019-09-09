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

    @Test
    public void testQueue2(){
        String[] items = {"13", "2", "78", "32"};

        // 入队
        ArrayQueue arrayQueue = new ArrayQueue(6);
        for(String item : items){
            arrayQueue.enqueue(item);
        }

        // 两次出队
        for(int i = 0; i < 2; i++){
            System.out.print(arrayQueue.dequeue() + " ");
        }

        // 再入队，使队尾满
        arrayQueue.enqueue("23");
        arrayQueue.enqueue("81");
        // 入队失败
        System.out.println("\n" + arrayQueue.enqueue("1"));
        // 输出当前队列
        arrayQueue.print();

        // 采用元素迁移式入队方法
        arrayQueue.enqueueWithMoveItem("1");
        System.out.println();
        arrayQueue.print();
    }
}
