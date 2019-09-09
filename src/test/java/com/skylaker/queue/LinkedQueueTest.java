package com.skylaker.queue;

import org.junit.jupiter.api.Test;

/**
 * @author skylaker2019@163.com
 * @version V1.0 2019/9/9 11:31 PM
 */
public class LinkedQueueTest {
    @Test
    public void testQueue(){
        String[] items = {"13", "2", "78", "32", "99", "67"};

        // 入队
        LinkedQueue linkedQueue = new LinkedQueue();
        for(String item : items){
            linkedQueue.enqueue(item);
        }
        linkedQueue.print();
        System.out.println();


        // 出队
        for(int i = 0; i < 8; i++){
            System.out.print(linkedQueue.dequeue() + " ");
        }
        System.out.println();
        linkedQueue.print();

        // 再次尝试入队
        linkedQueue.enqueue("3");
        System.out.println();
        linkedQueue.print();
    }
}
