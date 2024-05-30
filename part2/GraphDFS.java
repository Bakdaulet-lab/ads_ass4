package part2;

import java.util.*;

public class GraphDFS {

    // Graph represented using adjacency list
    private Map<Character, List<Character>> adjList = new HashMap<>();
    private Set<Character> visited = new HashSet<>();

    // Method to add an edge between two nodes
    public void addEdge(char src, char dest) {
        adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
    }

    // Depth-First Search (DFS) recursive method
    private void dfs(char node) {
        // Mark the current node as visited
        visited.add(node);
        System.out.print(node + " ");

        // Recur for all the vertices adjacent to this vertex
        for (char neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor);
            }
        }
    }

    public void performDFS(char startNode) {
        dfs(startNode);
    }

    public static void main(String[] args) {
        GraphDFS graph = new GraphDFS();

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

        // Perform DFS starting from node 'A'
        System.out.println("DFS starting from node A:");
        graph.performDFS('A');
    }
}
/* Detailed Trace
Start at node A, mark it as visited.

Visited: {A}
Stack: [A]
Explore the first adjacent node of A which is C.

Visited: {A, C}
Stack: [A, C]
Explore the first adjacent node of C which is A. A is already visited, so move to the next adjacent node B.

Visited: {A, C, B}
Stack: [A, C, B]
Explore the first adjacent node of B which is A. A is already visited, so move to the next adjacent node C. C is already visited, so move to the next adjacent node E.

Visited: {A, C, B, E}
Stack: [A, C, B, E]
Explore the first adjacent node of E which is G.

Visited: {A, C, B, E, G}
Stack: [A, C, B, E, G]
Explore the first adjacent node of G which is F.

Visited: {A, C, B, E, G, F}
Stack: [A, C, B, E, G, F]
Explore the first adjacent node of F which is G. G is already visited, so move to the next adjacent node E. E is already visited, so backtrack to G.

Visited: {A, C, B, E, G, F}
Stack: [A, C, B, E, G]
Backtrack to E, and explore its next adjacent node B. B is already visited, so backtrack to B.

Visited: {A, C, B, E, G, F}
Stack: [A, C, B]
Backtrack to B, and explore its next adjacent node G. G is already visited, so backtrack to C.

Visited: {A, C, B, E, G, F}
Stack: [A, C]
Backtrack to C, and explore its next adjacent node D.

Visited: {A, C, B, E, G, F, D}
Stack: [A, C, D]
Explore the first adjacent node of D which is C. C is already visited, so move to the next adjacent node A. A is already visited, so backtrack to C.

Visited: {A, C, B, E, G, F, D}
Stack: [A, C]
Backtrack to A, and explore its next adjacent node B. B is already visited, so move to the next adjacent node D. D is already visited, so the search is complete.

Visited: {A, C, B, E, G, F, D}
Stack: []
Order of Nodes Visited
The order in which the nodes are visited during the DFS starting from node A is:

A
C
B
E
G
F
D */