package com.skylaker.search;

/**
 * 二分查找：有重复元素值
 * @author skylaker
 * @version V1.0 2019/12/12 23:13
 */
public class BinarySearch2 {
    public static void main(String[] args) {
        int[] a = {1, 2, 11, 18, 23, 23, 23, 32, 45, 56, 66, 72, 80, 99, 198};
//        System.out.println(searchFirstEqual(a, a.length, 66));
//        System.out.println(searchLastEqual(a, a.length, 23));
//        System.out.println(searchFirstEqualOrLagger(a, a.length, -1));
        System.out.println(searchLastEqualOrLower(a, a.length, 1981));
    }


    /**
     * 查找第一个值等于给定值的元素
     *
     * @param array 目标数组
     * @param n     数组大小
     * @param value 要查找的值
     * @return 目标元素所在位置
     */
    public static int searchFirstEqual(int[] array, int n, int value){
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int middle = low + ((high - low) >> 2);

            if(array[middle] == value){
                if(middle == 0 || array[middle - 1] < value){
                    // 如果元素是第一个元素、或者说当前值等于目标值，并且前一个元素值小于当前值，
                    // 因为数组已经有序，那么前面的元素肯定不会有等于当前值的元素，即当前元素就是第一个等于目标值的元素
                    return middle;
                } else {
                    // 当前元素等于目标元素，但是前面紧挨着肯定还有相同元素，所以需要在之前的区间继续查找
                    high = middle - 1;
                }
            } else if(array[middle] > value){
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     *
     * @param array 目标数组
     * @param n     数组大小
     * @param value 要查找的值
     * @return 目标元素所在位置
     */
    public static int searchLastEqual(int[] array, int n, int value){
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int middle = low + ((high - low) >> 2);

            if(array[middle] == value){
                if(middle == n - 1 || array[middle + 1] > value){
                    return middle;
                } else {
                    low = middle + 1;
                }
            } else if(array[middle] > value){
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }

    /**
     * 查找第一个值大于等于给定值的元素
     *
     * @param array 目标数组
     * @param n     数组大小
     * @param value 要查找的值
     * @return 目标元素所在位置
     */
    public static int searchFirstEqualOrLagger(int[] array, int n, int value){
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int middle = low + ((high - low) >> 2);

            if(array[middle] >= value){
                if(middle == 0 || array[middle - 1] < value){
                    return middle;
                } else {
                    high = middle - 1;
                }
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }

    /**
     * 查找最后一个值小于等于给定值的元素
     *
     * @param array 目标数组
     * @param n     数组大小
     * @param value 要查找的值
     * @return 目标元素所在位置
     */
    public static int searchLastEqualOrLower(int[] array, int n, int value){
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int middle = low + ((high - low) >> 2);

            if(array[middle] <= value){
                if(middle == n - 1 || array[middle + 1] > value){
                    return middle;
                } else {
                    low = middle + 1;
                }
            } else {
                high = middle - 1;
            }
        }

        return -1;
    }
}
