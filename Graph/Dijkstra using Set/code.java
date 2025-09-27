import java.util.*;

class DijkstraUsingSet {
    static class Pair {
        int node;
        int dist;
        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void dijkstra(int V, List<List<Pair>> adj, int src) {
        // Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Set to get the minimum distance node
        // (distance, node)
        TreeSet<Pair> set = new TreeSet<>((a, b) -> {
            if (a.dist == b.dist) return a.node - b.node; // break tie
            return a.dist - b.dist;
        });

        set.add(new Pair(src, 0));

        while (!set.isEmpty()) {
            Pair p = set.pollFirst();  // smallest distance node
            int u = p.node;

            for (Pair edge : adj.get(u)) {
                int v = edge.node;
                int w = edge.dist;

                if (dist[u] + w < dist[v]) {
                    // If v already in set, remove it (to update)
                    set.remove(new Pair(v, dist[v]));

                    dist[v] = dist[u] + w;
                    set.add(new Pair(v, dist[v]));
                }
            }
        }

    }

   
}
