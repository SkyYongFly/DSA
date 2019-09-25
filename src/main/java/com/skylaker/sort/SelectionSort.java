package com.skylaker.sort;

/**
 * 选择排序
 * @author skylaker2019@163.com
 * @version V1.0 2019/9/25 11:56 PM
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {99, 80, 36, 21, 15, 8, 1, 89, 109, 23, 17, 2, 23};
		sort(a);
        print(a);
    }


    public static void sort(int[] a){
        if(null == a || a.length < 1){
            return;
        }

        for(int i = 0; i < a.length; i++){
            // 从剩下区间中选择最小的数
            int min = a[i];
            int index = i;
            for(int j = i; j < a.length; j++){
                if(min > a[j]){
                    min = a[j];
                    index = j;
                }
            }
            // 如果index不是当前i说明最小数不是当前i下标数，需要交换
            if(i != index){
                int temp = a[i];
                a[i] = a[index];
                a[index] = temp;
            }
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
