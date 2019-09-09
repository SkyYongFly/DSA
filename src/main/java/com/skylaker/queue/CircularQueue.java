package com.skylaker.queue;

/**
 * 循环队列
 * @author skylaker2019@163.com
 * @version V1.0 2019/9/10 12:30 AM
 */
public class CircularQueue {
    // 数组
    private String[] items;
    // 数组长度
    private int n;
    // 队头下标
    private int head = 0;
    // 队尾下标
    private int tail = 0;

    public CircularQueue(int m){
        items = new String[m];
        n = m;
    }

    /**
     * 入队
     * @param item
     * @return
     */
    public boolean enqueue(String item){
        // 判断队列是否已经满了
        if((tail + 1 ) % n == head){
            return false;
        }

        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public String dequeue(){
        if(head == tail){
            return null;
        }

        String item = items[head];
        head = (head + 1) % n;
        return item;
    }

    /**
     * 打印元素
     */
    public void print(){
        if(head == tail){
            System.out.println("队列为空");;
        }

        int p = head;
        while(p != tail){
            System.out.print(items[p] + " ");

            p += 1;
            if(p >= n){
                p -= n;
            }
        }
    }
}
