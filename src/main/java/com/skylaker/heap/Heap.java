package com.skylaker.heap;


import org.junit.jupiter.api.Test;

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
     * 删除堆顶元素（大顶堆）
     */
    public void deleteMax(){
        // 边界检查
        if(n <= 0){
            return;
        }

        // 交换堆顶元素和最后一个元素值
        // 因为是删除堆顶元素，只需要将末尾元素放到堆顶
        heap[1] = heap[n];
        // 删除了一个元素，整体长度减一
        n--;

        // 进行自顶向下堆化处理
        int i = 1;
        while (true) {
            int maxPos = i;

            // 和两个子节点比较，找出最大的一个
            if(i*2 <= n && heap[maxPos] < heap[i * 2]) {
                maxPos = i * 2;
            }

            if(i*2+1 <= n && heap[maxPos] < heap[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }

            if (maxPos == i){
                // 如果当前节点比左右子树节点都大，说明已经符合大顶堆要求，无需再处理
                break;
            } else {
                // 如果当前节点（父节点）比左右子树一个节点小，说明需要堆化，即交换节点
                int temp = heap[i];
                heap[i] = heap[maxPos];
                heap[maxPos] = temp;

                // 当前指向的节点需要跳到选取的较大值左右子节点位置
                i = maxPos;
            }
        }
    }

    /**
     * 堆排序
     * @param a 需要排序的数组，索引从 0 开始
     */
    public void heapSort(int[] a){
        if(null == a || 0 == a.length){
            return;
        }

        int length = a.length;

        // 1、建堆
        // 将数组映射成一个完全二叉树，但是还不满足堆的节点大小顺序要求，所以先堆化
        // 从非叶子节点开始
        heapMax(a);

        // 2、排序
        while (length >= 1){
            // 依次取堆顶元素，即大顶堆堆顶元素为最大值
            // 交换堆顶元素和末尾元素
            int temp = a[length - 1];
            a[length - 1] = a[0];
            a[0] = temp;

            // 索引位置往前移动一个，即剩下的元素堆化
            length--;

            // 每次剩下的元素要堆顶开始堆化（因为堆顶是之前末尾元素替换上去的）
            heapify(a, length , 0);
        }
    }

    /**
     * 任意一个数组建成大顶堆
     * @param a
     */
    public void heapMax(int[] a) {
        if (null == a || 0 == a.length) {
            return;
        }

        int length = a.length;

        // 将数组映射成一个完全二叉树，但是还不满足堆的节点大小顺序要求，所以先堆化
        // 从非叶子节点开始
        for (int i = (length-2)/2; i >= 0; i--) {
            heapify(a, length, i);
        }
    }

    /**
     * 堆化（从上往下）
     * @param a 目标数组 （元素从索引0开始）
     * @param length  数组长度
     * @param i 当前开始堆化的元素位置
     */
    private void heapify(int[] a, int length, int i) {
        while (true) {
            // 和左右两个子节点比较获取最大值节点
            // 并且需要判断左右子节点是否在范围内
            int maxPos = i;
            if(i*2+1 < length && a[maxPos] < a[i * 2 + 1]){
                maxPos = i * 2 + 1;
            }

            if(i*2+2 < length && a[maxPos] < a[i * 2 + 2]){
                maxPos = i * 2 + 2;
            }

            if(maxPos == i){
                // 最大是自身即父节点，满足大顶堆特性，结束
                break;
            } else {
                // 不满足，交换位置
                int temp = a[i];
                a[i] = a[maxPos];
                a[maxPos] = temp;

                // 继续向下比较
                i = maxPos;
            }
        }
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
        System.out.println();
    }

    public void print(int[] a){
        for(int data : a){
            System.out.print(data + " ");
        }
        System.out.println();
    }

}
