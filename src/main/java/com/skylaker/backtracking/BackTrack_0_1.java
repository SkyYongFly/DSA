package com.skylaker.backtracking;

/**
 * 回溯算法: 0-1背包问题
 * @author skylaker
 * @version V1.0 2020/5/23 0:00
 */
public class BackTrack_0_1 {
    public static void main(String[] args) {
        // 测试物品
        int[] arr = {20, 90, 9, 7, 2};

        bestWeight = 0;
        maxWeight = 100;
        // 从第一个物品开始选择，类似树从根节点开始遍历
        b(0, 0, arr);

        System.out.println(bestWeight);
    }

    // 能放到背包的最大重量
    public static int bestWeight = 0;
    // 背包限制的最大重量
    public static int maxWeight = 0;

    /**
     * 0-1 背包解法
     * @param i 当前物品索引
     * @param hasWeight  已装进背包物品重量
     * @param arr 物品对应重量数组，下标物品索引，值为对应重量
     */
    public static void b(int i, int hasWeight, int[] arr){
        // 1、 判断已经放入的物品总质量是否达到背包限制，如果达到那么就不需要再往后添加物品，
        //    这里不用 currentWeight == maxWeight 因为在上一个物品加入的时候已经判断了
        //    添加进背包的总质量不能大于限制，最大就是等于背包限制，那么这里 currentWeight 肯定不会比 maxWeight 大
        // 2、如果物品都添加完了自然添加操作结束
        //    如果最后一个物品操作完会将索引加1选择下一个物品，则下一个物品索引为 arr.length - 1 + 1 = arr.length，而这个物品其实是不存在的
        if(hasWeight == maxWeight || i == arr.length) {
            return;
        }

        // 当前物品先不放, 直接放下一个物品
        // TODO 对一个物品操作逻辑，只不过这里因为物品不选择，没有需要处理的逻辑
        b(i + 1, hasWeight,  arr);

        // 当前物品放，但是需要先判断如果放入当前物品总质量是否会超出限制
        // 这里其实就是相当于剪枝操作，如果放入当前这个节点已经不满足条件的话，那么对于这个节点分支都放弃，
        // 那么就回退到上一个节点，对于代码来说就是方法调用返回，就是 i-1 那个物品方法调用
        if(arr[i] + hasWeight <= maxWeight) {
            // 当前物品放进去，那么现有总重量就增加
            hasWeight += arr[i];
            if(hasWeight > bestWeight) {
                bestWeight = hasWeight;
            }

            // 继续对下一个物品操作
            b(i + 1, hasWeight, arr);
        }
    }

}
