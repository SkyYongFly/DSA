package com.skylaker.advanced;

import org.junit.jupiter.api.Test;

/**
 * @author skylaker
 * @version V1.0 2020/6/3 22:47
 */
public class TopologicSortingTest {
    @Test
    public void testKahn() {
        GraphTopologicalSorting graph = new GraphTopologicalSorting(6);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 5);
        graph.addEdge(3, 2);
        graph.addEdge(2, 4);
        graph.addEdge(4, 3);

        graph.sortByKahn();
    }
}
