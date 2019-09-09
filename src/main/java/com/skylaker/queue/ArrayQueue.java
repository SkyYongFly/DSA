package com.skylaker.queue;

/**
 * 顺序队列
 * @author skylaker2019@163.com
 * @version V1.0 2019/9/9 10:04 PM
 */
public class ArrayQueue {
    // 内部数组
    private String[] items;
    // 数组大小：n，即队列大小
    private int n = 0;
    // 队头下标：指向第一个实际元素
    private int head = 0;
    // 队尾下标：指向最后一个元素的后一节点，即入队元素要保存进的位置
    private int tail = 0;

    /**
     * 申请一个大小为 m 的数组
     * @param m
     */
    public ArrayQueue(int m){
        items = new String[m];
        n = m;
    }

    /**
     * 入队操作（不做判空操作，即允许存储空数据）
     * @param item 入队元素
     * @return 成功 true；失败 false
     */
    public boolean enqueue(String item){
        // 判断队列是否已经满
        if(tail == n){
            return false;
        }

        items[tail] = item;
        tail++;
        return true;
    }

    /**
     * （带元素空间调整的）入队操作
     * @param item 入队元素
     */
    public boolean enqueueWithMoveItem(String item){
        // 判断队列是否已满
        if(tail == n){
            if(head == 0){
                // 队头在第一个位置，队尾在末尾位置，说明整个队列已经真正满了，无法再入队
                return false;
            }

            // 说明即使队尾已无法入队，但是队头前还有剩余空间，进行元素搬移操作
            for(int i = head; i < tail; i++){
                items[i - head] = items[i];
            }

            // 调整队头和队尾（注意先要调整队尾）
            tail = tail - head;
            head = 0;
        }

        // 再进行入队操作
        items[tail] = item;
        tail++;
        return true;
    }


    /**
     * 出队操作
     * @return
     */
    public String dequeue(){
        // 判断队列是否为空
        if(head == tail){
            return null;
        }

        String item = items[head];
        head++;
        return item;
    }

    /**
     * 打印队列元素
     */
    public void print(){
        if(tail == head){
            return;
        }

        // 注意不是从0到n打印数组，而是队头到队尾之间元素
        for(int i = head; i < tail; i++){
            System.out.print(items[i] + " ");
        }
    }
}
