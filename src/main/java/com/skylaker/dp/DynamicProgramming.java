package com.skylaker.dp;

/**
 * 动态规划：求 0-1 背包问题
 * @author skylaker
 * @version V1.0 2020/5/23 17:49
 */
public class DynamicProgramming {
    public static void main(String[] args) {
        // 测试物品
        int[] arr = {20, 55, 20, 71, 15};
        System.out.println(bestWeight(arr, 100));
        System.out.println(bestWeight2(arr, 100));
    }

    /**
     * 利用动态规划（二维数组）求解 0-1 背包问题 能存放的最大物品重量
     * @param weight  每个物品对应的重量
     * @param maxWeight 背包限制最大重量
     * @return 能放到背包最大重量
     */
    public static int bestWeight(int[] weight, int maxWeight) {
        // 构建二维状态数组
        boolean states[][] = new boolean[weight.length][maxWeight + 1];

        // 后续的物品选择结果是要基于前面的状态来的，那么对于第一个物品来说，直接将选择不选择情况设置到状态表中
        // 不选择, 即列表示的选择重量为 0
        states[0][0] = true;
        // 选择，那么对应到列就是第一个物品的重量，但是要注意重量范围不能超出限制
        if(weight[0] <= maxWeight) {
            states[0][weight[0]] = true;
        }

        // 开始依次往后选择，填充状态表
        for(int k = 1; k < weight.length; k++) {
            // 第 k+1 个物品不选择，那么已选择物品的重量其实是和 k - 1 是一致的
            for(int j = 0; j <= maxWeight; j++) {
                if(true == states[k-1][j]) {
                    states[k][j] = true;
                }
            }

            // 第 k+1 个物品选择，那么就需要在 k-1 物品选择重量基础上加上当前重量
            // 同时需要注意加上当前物品后已有总重量不能大于背包总重量
            for(int j = 0; j <= maxWeight - weight[k]; j++) {
                if(true == states[k-1][j]) {
                    states[k][j + weight[k]] = true;
                }
            }
        }

        // 遍历最后一行，第一个为 true 的即为最优解
        for(int m = maxWeight; m >= 0 ; m--) {
            if(true == states[weight.length-1][m]) {
                return m;
            }
        }
        // 没有合适解
        return 0;
    }

    /**
     * 利用动态规划（一维状态数组)求解 0-1 背包问题 能存放的最大物品重量
     * @param weight  每个物品对应的重量
     * @param maxWeight 背包限制最大重量
     * @return 能放到背包最大重量
     */
    public static int bestWeight2(int[] weight, int maxWeight) {
        // 构建一维状态数组
        // 下标为 背包可能存放物品重量; 值为 该重量是否是可能解
        boolean[] states = new boolean[maxWeight + 1];

        // 对于第一个物品对应状态直接初始化
        // 第一个物品不选
        states[0] = true;
        // 第一个物品选
        if(weight[0] <= maxWeight) {
            states[weight[0]] = true;
        }

        // 从第2个物品开始选
        for(int k = 1; k < weight.length; k++) {
            // 第 k+1 个物品不选，那么其实对于一维数组来说值是不变的
            // do nothing

            // 第 k+1 个物品选择，需要从能够操作的已有物品总总量倒序操作
            for(int m = maxWeight - weight[k]; m >= 0; m--) {
                if(true == states[m]) {
                    states[m + weight[k]] = true;
                }
            }
        }

        // 从后往前第一个为 true 的总量即为最优解
        for(int m = maxWeight; m >= 0; m--) {
            if(true == states[m]) {
                return m;
            }
        }
        // 未找到最优解
        return 0;
    }
}
