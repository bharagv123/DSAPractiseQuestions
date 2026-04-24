package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        int V = 4;

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (u -> v, weight)
        adj.get(0).add(new Pair(1, 4));
        adj.get(0).add(new Pair(2, 1));
        adj.get(2).add(new Pair(1, 2));
        adj.get(1).add(new Pair(3, 1));
        adj.get(2).add(new Pair(3, 5));

        dijkstra(V, adj, 0);
    }

    private static void dijkstra(int V, List<List<Pair>> adj, int source) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // Min Heap (Priority Queue)
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> a.weight - b.weight
        );
        // Distance to source = 0
        dist[source] = 0;
        pq.add(new Pair(source, 0));
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int currWeight = current.weight;
            // Traverse all adjacent nodes
            for (Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.node;
                int edgeWeight = neighbor.weight;
                // Relaxation condition
                if (currWeight + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = currWeight + edgeWeight;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
        // Print shortest distances
        for (int i = 0; i < V; i++) {
            System.out.println("Distance from source to " + i + " = " + dist[i]);
        }
    }
}
