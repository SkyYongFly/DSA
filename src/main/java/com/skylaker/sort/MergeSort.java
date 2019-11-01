package com.skylaker.sort;

/**
 * 归并排序：核心思想，先将目标数组分解，再依次将分解的子数组从小串联合并起来
 * @author skylaker2019@163.com
 * @version V1.0 2019/11/1 11:59 PM
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = {99, 80, 198, 66, 32, 1, 23, 45, 2, 18, 56, 72, 11};
        sort(a);
        print(a);
    }

    private static void sort(int[] a){
        if(null == a || a.length < 1){
            return;
        }

        sort_merge(a, 0, a.length - 1);
    }

    /**
     * 排序数组a 索引p到r之间的元素
     * @param a 目标数组
     * @param p 开始索引位置
     * @param r 结束索引位置
     */
    private static void sort_merge(int[] a, int p, int r){
        if(p >= r){
            return;
        }

        // 取待排序数组中间索引位置
        int q = (p + r) / 2;

        // 排序前半段
        sort_merge(a, p, q);
        // 排序后半段
        sort_merge(a, q+1, r);

        // 合并前后两段
        merge(a, p, q, r);
    }

    /**
     * 合并数组前后半段（前后半段已经分别排好序）
     * @param a 目标数组
     * @param p 开始索引位置
     * @param q 中间索引位置
     * @param r 结束索引位置
     */
    private static void merge(int[] a, int p, int q, int r){
        // 申请临时数组空间（注意这里申请临时数组大小）
//        int[] b = new int[a.length];
        int[] b = new int[r - p + 1];

        // i 前半段数组游标 j 后半段数组游标
        int i = p, j = q + 1;
        // k 临时数组索引
        int k = 0;

        // 依次从前后半段数组取最小的值，串起来
        while(i <= q && j <= r){
            if(a[i] <= a[j]){
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
            }
        }

        // 将前后半段中剩下的元素放到临时数组的后面（它们就是最大的元素）
        int start = i, end = q;
        if(j <= r){
            start = j;
            end = r;
        }
        while(start <= end){
            b[k++] = a[start++];
        }

        // 将临时数组复制回原数组(注意回写的索引位置)
//        for(int t = 0; t < b.length; t++){
        int m = p;
        for(int t = 0; t < b.length; t++){
            a[m++] = b[t];
        }
    }

    private static void print(int[] a) {
        if(null == a || a.length < 1) {
            System.out.println("数组无内容！");
            return;
        }

        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
