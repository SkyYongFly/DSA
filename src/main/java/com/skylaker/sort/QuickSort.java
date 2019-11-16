package com.skylaker.sort;

/**
 * 快速排序
 * @author skylaker2019@163.com
 * @version V1.0 2019/11/3 12:26 PM
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {99, 80, 198, 66, 32, 1, 23, 45,99, 2, 18, 56, 72, 11};
        sort(a);
        print(a);
    }

    private static void sort(int[] a){
        if(null == a || a.length < 1){
            return;
        }

        quick_sort(a, 0, a.length - 1);
    }

    /**
     * 对数组p到r区间内容元素执行快速排序
     * @param a 目标数组
     * @param p 开始索引位置
     * @param r 结束索引位置
     */
    private static void quick_sort(int[] a, int p, int r){
        // 设置递归终止条件
        if(p >= r){
            return;
        }

        int q = partition(a, p , r);
        // 注意这里递归的索引范围，因为返回的q位置即上一个目标分区点已排序合适位置
        // 下一次排序的应该分别是前后半段
        quick_sort(a, p, q - 1);
        quick_sort(a, q + 1, r);
    }

    /**
     * 对目标数组进行分区排序：
     *  找到分区点，将小于分区点的元素放到分区点前面；大于分区点的元素在后面，
     *  即将目标分区点元素找到其最终对应的位置，前后再依次找分区点元素位置，最终有序
     *
     * @param a      目标数组
     * @param start  开始索引位置
     * @param end    结束索引位置
     * @return {int} 分区点元素最终应该排好序后的索引位置
     */
    private static int partition(int[] a, int start, int end){
        // 默认以最后一个元素作为分区点元素
        int point = end;
        // 小于分区点的元素分区段最后一个索引位置
        // 例如 3 2 8 4 5 中 i 在元素2位置
        int i = start;

        for(int j = start; j <= end - 1; j++){
            if(a[j] < a[point]){
                // 如果在相同位置就没必要交换了
                if(i != j) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }

                i++;
            }
        }

        // 最终交换分区点元素至i索引位置
        int temp = a[i];
        a[i] = a[point];
        a[point] = temp;

        return i;
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
