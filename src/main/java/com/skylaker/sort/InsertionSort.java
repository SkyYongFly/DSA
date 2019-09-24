package com.skylaker.sort;

/**
 * 插入排序
 * @author skylaker2019@163.com
 * @version V1.0 2019/9/23 11:51 PM
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] a = {99, 80, 32, 36, 21, 15, 8, 1, 89, 109, 23, 17, 2, 23};
        sort(a);
        print(a);
    }

    public static void sort(int[] a){
        if(null == a || a.length < 1){
            return;
        }

        // 从第二个元素开始，第一个元素一开始被当成以排序有序序列
        for(int i = 1; i < a.length; i++){
            // 需要缓存当前未排序第一个元素值，因为后期再用a[i]取值可能该位置值已被更新
            int temp = a[i];
            int j ;
            for(j = i - 1; j >= 0; j--){
                if(a[j] > temp){
                    // 如果被比较元素比当前待比较元素大，则位置后移一位
                    a[j+1] = a[j];
                }else{
                    // 如果小于等于则说明已排序序列和当前未排序第一个序列已经是有序了
                    break;
                }
            }
            // 将未排序第一个元素值放到已排序序列元素后移留出的空位置
            a[j + 1] = temp;
        }
    }

    public static void print(int[] a) {
        if(null == a || a.length < 1) {
            System.out.println("数组无内容！");
            return;
        }

        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
