class Solution {

    // Pair class to store node and its distance
    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        // Distance array, initialized to a large value
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) dist[i] = (int) 1e9;

        // BFS using queue of Pair objects
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        dist[src] = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int node = p.node;
            int d = p.dist;

            for (int neighbor : adj.get(node)) {
                if (d + 1 < dist[neighbor]) {
                    dist[neighbor] = d + 1;
                    q.add(new Pair(neighbor, d + 1));
                }
            }
        }

        // Mark unreachable nodes as -1
        for (int i = 0; i < n; i++) {
            if (dist[i] == (int) 1e9) dist[i] = -1;
        }

        return dist;
    }
}
