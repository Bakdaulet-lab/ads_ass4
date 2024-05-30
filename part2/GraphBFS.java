package part2;

import java.util.*;

public class GraphBFS {

    // Graph represented using adjacency list
    private Map<Character, List<Character>> adjList = new HashMap<>();
    private Set<Character> visited = new HashSet<>();

    // Method to add an edge between two nodes
    public void addEdge(char src, char dest) {
        adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
    }

    // Breadth-First Search (BFS) method
    public void bfs(char startNode) {
        Queue<Character> queue = new LinkedList<>();

        // Mark the start node as visited and enqueue it
        visited.add(startNode);
        queue.add(startNode);

        while (!queue.isEmpty()) {
            char node = queue.poll();
            System.out.print(node + " ");

            // Get all adjacent nodes
            for (char neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphBFS graph = new GraphBFS();

        // Adding edges to the graph
        graph.addEdge('A', 'C');
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'D');
        graph.addEdge('B', 'A');
        graph.addEdge('B', 'C');
        graph.addEdge('B', 'E');
        graph.addEdge('B', 'G');
        graph.addEdge('C', 'A');
        graph.addEdge('C', 'B');
        graph.addEdge('C', 'D');
        graph.addEdge('D', 'C');
        graph.addEdge('D', 'A');
        graph.addEdge('E', 'G');
        graph.addEdge('E', 'F');
        graph.addEdge('E', 'B');
        graph.addEdge('F', 'G');
        graph.addEdge('F', 'E');
        graph.addEdge('G', 'F');
        graph.addEdge('G', 'B');

        // Perform BFS starting from node 'A'
        System.out.println("BFS starting from node A:");
        graph.bfs('A');
    }
}
/* Detailed Trace
Start at node A, mark it as visited, and enqueue it.

Visited: {A}
Queue: [A]
Dequeue A and explore its adjacent nodes (C, B, D), marking them as visited and enqueuing them.

Visited: {A, C, B, D}
Queue: [C, B, D]
Dequeue C and explore its adjacent nodes (A, B, D). All are already visited.

Visited: {A, C, B, D}
Queue: [B, D]
Dequeue B and explore its adjacent nodes (A, C, E, G), marking E and G as visited and enqueuing them.

Visited: {A, C, B, D, E, G}
Queue: [D, E, G]
Dequeue D and explore its adjacent nodes (C, A). Both are already visited.

Visited: {A, C, B, D, E, G}
Queue: [E, G]
Dequeue E and explore its adjacent nodes (G, F, B), marking F as visited and enqueuing it.

Visited: {A, C, B, D, E, G, F}
Queue: [G, F]
Dequeue G and explore its adjacent nodes (F, B). Both are already visited.

Visited: {A, C, B, D, E, G, F}
Queue: [F]
Dequeue F and explore its adjacent nodes (G, E). Both are already visited.

Visited: {A, C, B, D, E, G, F}
Queue: []
Order of Nodes Visited
The order in which the nodes are visited during the BFS starting from node A is:

A
C
B
D
E
G
F */
