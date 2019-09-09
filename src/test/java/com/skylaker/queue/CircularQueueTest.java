package com.skylaker.queue;

import org.junit.jupiter.api.Test;

/**
 * @author skylaker2019@163.com
 * @version V1.0 2019/9/10 12:44 AM
 */
public class CircularQueueTest {
    @Test
    public void testCircularQueue(){
        String[] items = {"13", "2", "78", "32", "99", "67"};

        CircularQueue circularQueue = new CircularQueue(7);
        for(String item : items){
            circularQueue.enqueue(item);
        }
        circularQueue.print();

        System.out.println("\n" + circularQueue.enqueue("1"));

        circularQueue.dequeue();
        circularQueue.dequeue();
        System.out.println();
        circularQueue.print();

    }
}
