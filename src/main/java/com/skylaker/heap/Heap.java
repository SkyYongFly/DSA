package com.skylaker.heap;


/**
 * 堆
 * @author skylaker
 * @version V1.0 2020/1/9 22:18
 */
public class Heap {
    // 堆直接用数组存储
    private int[] heap ;

    // 堆中能存储的最大元素个数
    private int max;

    // 堆中已经存储的元素个数
    private int n;

    /**
     * 初始化构造堆
     * @param initLength 设置的堆最大容量
     */
    public Heap(int initLength){
        // 申请容量需要预留一个首空位置
        heap = new int[initLength + 1];
        max = initLength;
        n = 0;
    }


    /**
     * （大顶堆）堆中插入元素
     * @param data
     */
    public void insert(int data){
        // 首先判断堆是否已满
        if(n >= max){
            return;
        }

        // 将元素放到堆中最后一个节点
        heap[++n] = data;

        // 进行堆化处理，采用从下往上堆化
        int p = n;
        while (p / 2 >= 1 && heap[p] > heap[p / 2]){
            // 节点比父节点值大，则进行值交换
            int temp = heap[p];
            heap[p] = heap[p / 2];
            heap[p / 2] = temp;

            p = p / 2;
        }
    }

    /**
     * 为了测试方便设置节点值 (假设节点已经存在)
     * @param data 目标节点值
     * @param index 节点位置
     */
    public void setNode(int data, int index){
        heap[index] = data;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setN(int n) {
        this.n = n;
    }

    /**
     * 打印输出
     */
    public void print(){
        if(0 == n){
            return;
        }

        for(int i = 1; i <= n; i++){
            System.out.print(heap[i] + " ");
        }
    }
}
