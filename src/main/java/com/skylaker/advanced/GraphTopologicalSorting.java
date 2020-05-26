package com.skylaker.advanced;

import java.util.LinkedList;

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


}
