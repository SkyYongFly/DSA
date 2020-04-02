package com.skylaker.heap;

import org.junit.jupiter.api.Test;

/**
 * @author skylaker
 * @version V1.0 2020/4/2 22:30
 */
public class HeapTest {
    @Test
    public void testHeapSort(){
        int[] arr = {23,15,16,2,25,31,3,11,8};
        Heap heap = new Heap(1);
        heap.heapSort(arr);
        heap.print(arr);
    }

    @Test
    public void testDeleteMax(){
        int[] arr = {31, 25, 23, 11, 15, 16, 3, 2, 8};
        Heap heap = new Heap(9);
        for(int a : arr){
            heap.insert(a);
        }
        heap.deleteMax();
        heap.print();
    }
}
