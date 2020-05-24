package com.skylaker.dp;

/**
 *  类似杨辉三角，每个位置的数字可以随意填写，经过某个数字只能到达下面一层相邻的两个数字。
 *  从第一层，往下移动，我们把移动到最底层所经过的所有数字之和，定义为路径的长度。
 *  请你编程求出从最高层移动到最底层的最短路径长度 。
 *          5
 *         / \
 *       7     8
 *      /  \  /  \
 *     2     3    4
 *    /  \  /  \ /  \
 *   4    9     6    1
 *
 * @author skylaker
 * @version V1.0 2020/5/24 10:53
 */
public class Triangle {
    public static void main(String[] args) {
        int[][] triangle = {{5}, {7,8}, {2,3,4}, {4,9,6,1}};
        System.out.println(dpStatesTable(triangle));
    }

    /**
     * 利用状态表求解
     * @param triangle “杨辉三角”对应的二维数组，一维代表每一层，二维代表每一行数字
     * @return 最高层到最底层的最短路径
     */
    public static int dpStatesTable(int[][] triangle) {
        // 1、定义状态表
        // 行代表每一层
        // 列代表层的数字最大个数，用最底层数字个数作为列
        // 值代表当前数字选择后最短路径
        int[][] states = new int[triangle.length][triangle.length];

        // 2、开始填表
        // 初始化第一层
        states[0][0] = triangle[0][0];

        // 第二层开始依赖前一层处理
        for(int c = 1; c < triangle.length; c++) {
            for(int k = 0; k < triangle[c].length; k++) {
                // 当前层最右边数字索引
                int rightIndex = triangle[c].length - 1;

                if(0 == k) {
                    // 最左边的数字最短路径就是上一个最左数字已有路径和加上当前数字
                    states[c][0] = states[c - 1][0] + triangle[c][0];
                }
                else if(k == rightIndex) {
                    // 上一层最右边数字索引
                    int upRightIndex = triangle[c-1].length - 1;
                    // 最右边数字最短路径就是上一个最右边数字已有路径和加上当前数字
                    states[c][rightIndex] = states[c-1][upRightIndex] + triangle[c][rightIndex];
                }
                else {
                    // 如果是中间数字，那么 最短路径 = 上一层相连的两个数 字中的最短一个路径 + 当前数字
                    int upLeft = states[c-1][k-1];
                    int upRight = states[c-1][k];
                    states[c][k] = Math.min(upLeft, upRight) + triangle[c][k];
                }
            }
        }

        // 3、得到最优解
        // 这里状态表最后一层的数据就是最底层每个数字的最短路径，
        // 那么对于整个三角来说，最短路径就是这些最短路径中的最小值
        int bottomRow = states.length - 1;
        int min = states[bottomRow][0];
        for(int i = 0; i < states[bottomRow].length; i++) {
            if(states[bottomRow][i] < min) {
                min = states[bottomRow][i];
            }
        }
        return min;
    }

    /**
     * 利用状态转移方程求解
     * @param triangle “杨辉三角”对应的二维数组，一维代表每一层，二维代表每一行数字
     * @return 最高层到最底层的最短路径
     */
    public static int stateTransferEquation(int[][] triangle){

        return -1;
    }

}
