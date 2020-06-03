package com.skylaker.advanced;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 有向图：拓扑排序
 * @author skylaker
 * @version V1.0 2020/5/25 23:41
 */
public class GraphTopologicalSorting {
    // 有向图的定义
    // 顶点个数
    private int v;
    // 图的邻接表表示
    private LinkedList<Integer>[] list;


    /**
     * 图定义
     * @param v 顶点个数
     */
    public GraphTopologicalSorting (int v) {
        this.v = v;
        list = new LinkedList[v];
        for(int i = 0; i < v; i++) {
            list[i] = new LinkedList<>();
        }
    }

    /**
     * 图添加边，h 顶点到 t 顶点 ： h ——> t， h 先于 t
     * @param h 起始顶点
     * @param t 结束顶点
     */
    public void addEdge(int h, int t) {
        list[h].add(t);
    }

    /**
     * kahn算法实现拓扑排序：利用贪心算法
     *
     *  先找出入度为 0 的顶点，再找出入度为1的顶点…… 依次寻找遍历顶点
     */
    public void sortByKahn() {
        // 记录每个顶点入度数的数组
        int[] d = new int[v];

        // 先遍历邻接表统计出所有顶点的入度
        for(int i = 0; i < v; i++) {
            for(int j = 0; j < list[i].size(); j++) {
                // i 顶点的邻接表中的顶点就是 i 指向的顶点  i ——> list[i].get(j)
                int p = list[i].get(j);
                d[p]++;
            }
        }

        // 先从入度为 0 的顶点开始遍历
        // 构造一个队列，依次放入入度为 0 、1、2 …… 的顶点，作为临时中转
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        for(int i = 0; i < d.length; i++) {
            if(0 == d[i]) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            // 移除队列头节点， 一开始即入度为 0 的顶点中的第一个
            int p = queue.remove();
            System.out.print(" ——> " + p);

            // 遍历当前顶点的邻接表，并将指向的顶点的入度减 1
            for(int j = 0; j < list[p].size(); j++) {
                int pp = list[p].get(j);
                d[pp] --;

                // 如果指向的顶点入度减到为0，则说明就没顶点指向当前顶点了
                if(0 == d[pp]) {
                    queue.add(pp);
                }
            }
        }
    }
}
