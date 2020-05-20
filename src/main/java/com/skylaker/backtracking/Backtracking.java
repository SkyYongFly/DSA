package com.skylaker.backtracking;

/**
 * 回溯算法思想
 * @author skylaker
 * @version V1.0 2020/5/20 21:40
 */
public class Backtracking {
    public static void main(String[] args) {
        b8Queues();
    }


    // 8皇后算法中保存元素占用位置数组
    // 下标索引代表行，对应值代表列
    private static int[] data = new int[8];

    /**
     * 计算8皇后问题
     */
    public static void b8Queues() {
        data = new int[8];
        // 从第一行开始放置元素
        cal8Queues(0);
    }

    /**
     * 计算指定行元素应该放在哪一列
     * @param row 行数
     */
    private static void cal8Queues(int row){
        if(row >= 8) {
            // 每一行都放过元素，即已处理完毕
            printData();
            return;
        }

        // 元素在每一行都有8列位置可放
        for(int column = 0; column < 8; column++) {
            if(isOk(row, column)) {
                // 当前行、当前列所在位置能放置元素
                data[row] = column;

                // 继续放下一行元素
                cal8Queues(row + 1);
            }
        }
    }

    /**
     * 判断元素在指定行、指定列是否能放置，其实就是判断上面的列、左上角、右上角对应位置是否有元素
     * @param row 行
     * @param column 列
     * @return 能 ：true ; 不能 ：false
     */
    private static boolean isOk(int row, int column) {
        // 左边的列
        int leftColumn = column - 1;
        // 右边的列
        int rightColum = column + 1;

        // 依次判断前面的行
        for(int r = row - 1; r >= 0; r--) {
            // 判断上面相同列是否有元素
            if(data[r] == column) {
                return false;
            }

            // 判断左上角是否有元素
            if(data[r] == leftColumn) {
                return false;
            }

            // 判断右上角是否有元素
            if(data[r] == rightColum){
                return false;
            }

            // 需要继续往上一行位置判断
            leftColumn--;
            rightColum++;
        }

        return true;
    }

    /**
     * 打印8皇后元素位置
     */
    private static void printData() {

        for(int row = 0; row < 8; row++) {
            for(int column = 0; column < 8; column++) {
                if(data[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
