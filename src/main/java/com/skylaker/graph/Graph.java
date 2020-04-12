package com.skylaker.graph;

import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * 图的广度优先搜索 （核心思想：一层层往后搜索）
     * @param s 起点
     * @param t 终点
     */
    public void bfs(int s, int t){
        if(t <= s){
            return;
        }

        // 标识对应索引顶点是否已经访问
        boolean[] visited = new boolean[v];
        visited[s] = true;

        // 用队列缓存已经被访问，但是相连节点还未被访问的顶点
        // 方便依次向后每一层遍历，比如
        // 2——3——4——5
        // |  |  |
        // 6——7——8
        // 从2开始，2初始入队，然后获取2的关联顶点 3、6 入队，先弹出队列中的顶点 3，获取到关联的顶点4、7 入队，再弹出6 这样依次操作
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        // 数组每个索引位置表示对应顶点的前一个顶点，比如顶点3的前一个顶点是4，那么 prev[3]=4
        // 每个节点的前驱节点可能有多个，这里只存储遍历到的第一个
        int[] prev = new int[v];
        for(int i = 0; i < v; i++){
            prev[i] = -1;
        }

        while (queue.size() != 0){
            // 队列出队头结点
            int cur = queue.poll();
            // 遍历当前节点关联的顶点
            for(int i = 0; i < adj[cur].size(); i++){
                int node = adj[cur].get(i);
                if(!visited[node]){
                    // 先记录前驱节点
                    prev[node] = cur;

                    // 判断是否是目标节点
                    if(node == t){
                        print(prev, s, t);
                        return;
                    }

                    // 关联的顶点没有被访问
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }

    }

    /**
     * 打印顶点s到t的路径（递归打印，打印 s 到 t 的路径，那么就是 s 到 t 的上一个顶点加上打印 t 顶点）
     * @param prev 记录顶点前驱顶点的数组
     * @param s 起点
     * @param t 终点
     */
    public void print(int[] prev, int s, int t){
        if(-1 != prev[t] && s != t){
            print(prev, s, prev[t]);
        }

        System.out.printf(t + " ");
    }

    /**
     * 图的深度优先搜索 （核心思想：一条路往前走，不通则回退重走，递归实现）
     * @param s 起点
     * @param t 终点
     */
    public void dfs(int s, int t){
        if(t <= s){
            return;
        }

        // 标识对应索引顶点是否已经访问
        boolean[] visited = new boolean[v];
        visited[s] = true;

        // 数组每个索引位置表示对应顶点的前一个顶点，比如顶点3的前一个顶点是4，那么 prev[3]=4
        // 每个节点的前驱节点可能有多个，这里只存储遍历到的第一个
        int[] prev = new int[v];
        for(int i = 0; i < v; i++){
            prev[i] = -1;
        }

        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    /**
     * 递归深度优先搜索
     * @param s 当前起点
     * @param t 终点
     * @param visited 顶点已访问标识数组
     * @param prev 顶点前驱顶点数组
     */
    public void recurDfs(int s, int t, boolean[] visited, int[] prev){
        // 找到目标顶点结束
        if(s == t){
            return;
        }

        // 标识当前节点已访问
        visited[s] = true;

        // 遍历当前顶点的关联顶点
        for(int i = 0; i < adj[s].size(); i++){
            int cur = adj[s].get(i);
            if(!visited[cur]){
                prev[cur] = s;
                recurDfs(cur, t, visited, prev);
            }
        }
    }

}
