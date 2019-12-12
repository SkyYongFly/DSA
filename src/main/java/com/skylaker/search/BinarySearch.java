package com.skylaker.search;

/**
 * 简单二分查找：没有重复元素值
 * @author skylaker
 * @version V1.0 2019/12/12 22:13
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {1, 2, 11, 18, 23, 32, 45, 56, 66, 72, 80, 99, 198};
//        System.out.println(circleSearch(a, a.length, 198));
        System.out.println(recursionSearch(a,0, a.length - 1, 198));
    }


    /**
     * 循环查找算法
     *
     * @param array 目标数组
     * @param n     数组大小
     * @param value 要查找的值
     * @return 目标元素所在位置
     */
    public static int circleSearch(int[] array, int n, int value){
        // 基本异常判断

        int low = 0;
        int high = n - 1;

        while(low <= high){
//            int middle = (low + high) / 2;
//            int middle = low + (high - low) / 2;
            int middle = low + ((high - low) >> 2);

            if(array[middle] == value){
                return middle;
            } else if(array[middle] > value){
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }

    /**
     * 递归查找算法
     *
     * @param array 目标数组
     * @param start 查找区间开始位置
     * @param end 查找区间结束位置
     * @param value 要查找的值
     * @return 目标元素所在位置
     */
    public static int recursionSearch(int[] array, int start, int end,  int value){
        int middle = start + ((end - start) >> 2);

        if(array[middle] == value){
            return middle;
        } else if(array[middle] > value){
            return recursionSearch(array, start, middle - 1, value);
        } else {
            return recursionSearch(array, middle + 1, end, value);
        }
    }
}
