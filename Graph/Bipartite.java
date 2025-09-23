import java.util.*;

class Solution {
    // DFS function
    public boolean dfs(int node, int[] color, List<List<Integer>> adj) {
        for (int neighbor : adj.get(node)) {
            if (color[neighbor] == -1) {          // uncolored neighbor
                color[neighbor] = 1 - color[node]; // assign opposite color
                if (!dfs(neighbor, color, adj)) return false;
            } else if (color[neighbor] == color[node]) {
                return false; // neighbor has same color → not bipartite
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1); // -1 = uncolored

        // Convert graph[][] to adjacency list for convenience
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> neighbors = new ArrayList<>();
            for (int j : graph[i]) neighbors.add(j);
            adj.add(neighbors);
        }

        // Check all components
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {      // unvisited component
                color[i] = 0;          // color root
                if (!dfs(i, color, adj)) return false;
            }
        }

        return true;
    }
}
