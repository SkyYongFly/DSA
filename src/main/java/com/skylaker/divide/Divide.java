package com.skylaker.divide;

/**
 * 分治思想
 * @author skylaker
 * @version V1.0 2020/5/20 20:30
 */
public class Divide {
    // 逆序度计数
    private int num = 0;

    /**
     * 利用分治思想求数组的逆序度
     * @param arr 目标数组
     * @return {int} 数组的逆序度z
     */
    public int count(int[] arr){
        if(null == arr || 0 == arr.length){
            return 0;
        }

        num = 0;
        divideAndMergeArray(arr, 0, arr.length -1);
        return num;
    }

    /**
     * 归并处理数组
     * @param arr 目标数组
     * @param p 起始索引位置
     * @param r 结束索引位置
     */
    private void divideAndMergeArray(int[] arr, int p, int r){
        if(p >= r){
            return;
        }

        // 数组中间元素位置
        int m = (p + r) / 2;

        // 处理前半部分
        divideAndMergeArray(arr, p, m);
        // 处理后半部分
        divideAndMergeArray(arr, m + 1, r);

        // 合并两部分子数组
        merge(arr, p, m, r);
    }

    /**
     * 合并前后两个子数组
     * @param arr 目标数组
     * @param p 起始索引位置
     * @param m 中间索引位置
     * @param r 结束索引位置
     */
    private void merge(int[] arr, int p, int m, int r) {
        // 构建一个临时数组，用于存放当前两个子数组合并后的有序列
        int[] temp = new int[r - p + 1];

        // 构建前后两个子数组游标指针
        int x = p , y = m + 1;
        // 构建临时数组游标指针
        int k = 0;

        // 依次从两个子数组中取较小的一个元素值
        while (x <= m && y <= r) {
            if(arr[x] <= arr[y]) {
                // 前面子数组值较小或相等
                temp[k++] = arr[x++];
            }

            else {
                // 后一个子数组值较小
                // 计算逆序度，就是前面数组指针位置往后的元素个数
                num += ( m - x + 1 );

                temp[k++] = arr[y++];
            }
        }

        // 前一个子数组还有剩余值
        if(x <= m) {
            temp[k++] = arr[x++];
        }

        // 后一个子数组还有剩余值
        if(y <= r) {
            temp[k++] = arr[y++];
        }

        // 将临时有序数组元素替换到原数组位置
        for(int i = 0; i < temp.length; i++){
            arr[p + i] = temp[i];
        }
    }
}
