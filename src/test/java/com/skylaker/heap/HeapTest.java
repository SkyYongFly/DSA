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

    @Test
    public void testTopK(){
        int[] arr = {31, 8, 23, 1, 15, 3, 16, 2, 25};
        Heap heap = new Heap(0);
        int[] res = heap.getTopK(arr, 5);
        for(int a : res){
            System.out.print(a + " ");
        }

        System.out.println();

        int[] arr2 = {8, 2, 5, 3, 1, 6, 9, 4, 7};
        Heap heap2 = new Heap(0);
        int[] res2 = heap.getTopK(arr2, 5);
        for(int a : res2){
            System.out.print(a + " ");
        }
    }
}
