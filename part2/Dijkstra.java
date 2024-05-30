package part2;

import java.util.*;

public class Dijkstra {

    static class Edge {
        char target;
        int weight;

        Edge(char target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    static class Graph {
        private final Map<Character, List<Edge>> adjList = new HashMap<>();

        void addEdge(char src, char dest, int weight) {
            adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(new Edge(dest, weight));
            adjList.computeIfAbsent(dest, k -> new ArrayList<>()).add(new Edge(src, weight));
        }

        List<Edge> getEdges(char node) {
            return adjList.getOrDefault(node, new ArrayList<>());
        }
    }

    public static void dijkstra(Graph graph, char source, char destination) {
        // Priority queue to select the edge with the smallest weight
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        Map<Character, Integer> distances = new HashMap<>();
        Map<Character, Character> previous = new HashMap<>();
        Set<Character> visited = new HashSet<>();

        // Initialize distances
        for (char node : graph.adjList.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(source, 0);

        pq.add(new Edge(source, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            char currentNode = current.target;

            if (visited.contains(currentNode)) continue;
            visited.add(currentNode);

            // Check if we reached the destination
            if (currentNode == destination) break;

            // Update distances to neighbors
            for (Edge edge : graph.getEdges(currentNode)) {
                if (!visited.contains(edge.target)) {
                    int newDist = distances.get(currentNode) + edge.weight;
                    if (newDist < distances.get(edge.target)) {
                        distances.put(edge.target, newDist);
                        previous.put(edge.target, currentNode);
                        pq.add(new Edge(edge.target, newDist));
                    }
                }
            }
        }

        // Print shortest path from source to destination
        LinkedList<Character> path = new LinkedList<>();
        for (Character at = destination; at != null; at = previous.get(at)) {
            path.addFirst(at);
        }

        System.out.println("Shortest path from " + source + " to " + destination + ": " + path);
        System.out.println("Total distance: " + distances.get(destination));
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        // Add edges to the graph
        graph.addEdge('E', 'S', 50);
        graph.addEdge('E', 'P', 100);
        graph.addEdge('S', 'G', 50);
        graph.addEdge('S', 'P', 40);
        graph.addEdge('P', 'D', 60);

        // Find shortest path from Edinburgh (E) to Dundee (D)
        dijkstra(graph, 'E', 'D');
    }
}

