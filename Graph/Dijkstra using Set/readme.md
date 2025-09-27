# Dijkstra's Algorithm using TreeSet in Java

This implementation of **Dijkstra's Algorithm** uses a `TreeSet` (balanced BST) instead of a `PriorityQueue`. It maintains the **minimum distance node** efficiently while ensuring no duplicate entries exist for the same node.

## 📌 Algorithm Steps

### 1. Initialize distances
- Create an array `dist[]` of size `V` (number of vertices)
- Fill with `INF` (`Integer.MAX_VALUE`)
- Set `dist[src] = 0`

### 2. Prepare the set
- Use a `TreeSet<Pair>` (or `TreeSet<NodeDist>`)
- Comparator should sort by `(dist, node)` so the smallest distance is always first
- `Pair` contains `(node, dist)`
- Comparator must **break ties** by node id to ensure total ordering

### 3. Insert the source
```java
set.add(new Pair(src, 0));
```

### 4. Main loop
While the set is not empty:

#### Remove & get smallest
```java
Pair p = set.pollFirst();
int u = p.node;
```

#### Relax neighbors
For each edge (u → v, weight w):
```java
if (dist[u] + w < dist[v]) {
    set.remove(new Pair(v, dist[v]));   // remove old entry
    dist[v] = dist[u] + w;              // update distance
    set.add(new Pair(v, dist[v]));      // insert new entry
}
```

## ❓ Important Design Decisions

### Why remove before add?
- `TreeSet` must not contain duplicate entries for the same node with different distances
- Otherwise, outdated entries remain and waste time during polling
- `remove()` is efficient: O(log V)

### Why use `dist[u] + w` instead of `p.dist + w`?
- `p.dist` may be stale if the node was inserted earlier with a larger distance
- `dist[u]` always stores the latest confirmed shortest distance, making it safe

## ⚠️ Edge Cases & Rules

- Graph must have **non-negative weights** for Dijkstra to work correctly
- If `remove()` returns `false`, it means the old entry was already popped/removed — that's fine
- Ensure comparator uses both `dist` and `node` so different nodes with the same distance are ordered deterministically

## ⏱️ Time & Space Complexity

### Time Complexity
- Each `add()`, `remove()`, `pollFirst()` is **O(log V)**
- Overall runtime: **O((V + E) log V)** (same as heap-based Dijkstra)

### Space Complexity
- **O(V)** if you always remove old pairs
- If you skip `remove()`, space can grow larger due to outdated entries

## 📝 Pseudocode

```text
dist[] = INF
dist[src] = 0
set = TreeSet ordered by (dist, node)
set.add((src, 0))

while set not empty:
    p = set.pollFirst()
    u = p.node
    
    for each (v, w) in adj[u]:
        if dist[u] + w < dist[v]:
            set.remove((v, dist[v]))
            dist[v] = dist[u] + w
            set.add((v, dist[v]))
```
