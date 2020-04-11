package com.skylaker.graph;

import java.util.LinkedList;

/**
 * 图 （无向图）
 * @author skylaker
 * @version V1.0 2020/4/12 0:09
 */
public class Graph {
    // 顶点的个数
    private int v;

    // 用邻接表存储（链表数组）
    // 每个顶点对应到对应索引位置，节点中的链表保存与当前节点相连的顶点
    private LinkedList<Integer>[] adj;


    public Graph(int v){
        this.v = v;

        adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 存储两个顶点之间的边关系
     * @param s 顶点s
     * @param t 顶点t
     */
    public void addEdge(int s, int t){
        // 无向图两个顶点之间的关系是同时存在的，所以两个顶点要同时保存对应的边关系
        adj[s].add(t);
        adj[t].add(s);
    }

}
