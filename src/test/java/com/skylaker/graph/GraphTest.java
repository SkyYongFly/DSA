package com.skylaker.graph;

import org.junit.jupiter.api.Test;

/**
 * @author skylaker
 * @version V1.0 2020/4/12 15:43
 */
public class GraphTest {
    @Test
    public void testBFS(){
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 1);
        graph.addEdge(2, 5);
        graph.addEdge(3, 0);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 4);
        graph.addEdge(5, 7);
        graph.addEdge(6, 4);
        graph.addEdge(6, 7);
        graph.addEdge(7, 5);
        graph.addEdge(7, 6);

        graph.bfs(0,6);
        System.out.println();
        graph.dfs(0,6);
    }
}
