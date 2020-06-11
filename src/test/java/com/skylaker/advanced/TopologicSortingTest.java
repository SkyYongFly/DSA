package com.skylaker.advanced;

import org.junit.jupiter.api.Test;

/**
 * @author skylaker
 * @version V1.0 2020/6/3 22:47
 */
public class TopologicSortingTest {
    @Test
    public void testTopologicSorting() {
        GraphTopologicalSorting graph = new GraphTopologicalSorting(6);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 3);

        graph.sortByKahn();
        System.out.println();
        graph.sortByDfs();
    }
    @Test
    public void testTopologicSorting2() {
        GraphTopologicalSorting graph = new GraphTopologicalSorting(7);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(2, 4);
        graph.addEdge(4, 6);

        graph.sortByKahn();
        System.out.println();
        graph.sortByDfs();
    }
}
