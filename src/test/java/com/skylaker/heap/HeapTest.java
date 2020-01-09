package com.skylaker.heap;

import org.junit.jupiter.api.Test;

/**
 * @author skylaker
 * @version V1.0 2020/1/9 22:53
 */
public class HeapTest {
    @Test
    public void test(){
        Heap heap = new Heap(20);
        int[] nums = {33,27,21,16,13,15,9,5,6,7,8,1,2};
        for(int i = 0; i < 13 ; i++){
            heap.setNode(nums[i], i+1);
        }
        heap.setMax(20);
        heap.setN(13);

        // 输出插入元素堆化后的大顶堆
        heap.insert(22);
        heap.print();
    }
}
