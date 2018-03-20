package com.googlecodejam.practice.algorithims.graps;

import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraph {

    private int numberOfVertices;
    private LinkedList<Integer> adjacencylist[];


    BFSGraph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;

        adjacencylist = new LinkedList[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            adjacencylist[i] = new LinkedList<>();
        }

    }

    void addEdge(int vertex, int vertexDestination) {
        adjacencylist[vertex].add(vertexDestination);
        adjacencylist[vertexDestination].add(vertex);
    }

    List<Integer> BFS(int startNode) {

        boolean[] visited = new boolean[numberOfVertices];
        Queue<Integer> queue = Lists.newLinkedList();

        List<Integer> output = Lists.newLinkedList();


        visited[startNode] = true;
        queue.add(startNode);

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            output.add(node);

            for(Integer childNode : adjacencylist[node]) {

                boolean isVisited = visited[childNode];
                if (!isVisited) {
                    visited[childNode] = true;
                    queue.add(childNode);
                }
            }

        }

        return output;
    }

    public static void main(String[] args) {
        BFSGraph bfsGraph = new BFSGraph(5);
        bfsGraph.addEdge(0, 1);
        bfsGraph.addEdge(1, 2);
        bfsGraph.addEdge(2, 3);
        bfsGraph.addEdge(4, 3);

        List<Integer> bfs = bfsGraph.BFS(3);
        System.out.println("bfs = " + bfs);
    }

}
