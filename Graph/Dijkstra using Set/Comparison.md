# Why TreeSet over PriorityQueue or Queue?

## 🤔 The Problem with Other Data Structures

### ❌ Why NOT Regular Queue?
- **No ordering**: Queue follows FIFO (First In, First Out) principle
- **No priority**: Cannot prioritize nodes with smaller distances
- **Incorrect results**: Will not find shortest paths correctly
- **Dijkstra requirement**: Algorithm needs to always process the node with minimum distance first

### ❌ Why NOT PriorityQueue?
While PriorityQueue seems like the obvious choice, it has several limitations:

#### 1. **Duplicate Entries Problem**
```java
// PriorityQueue allows duplicates
PriorityQueue pq = new PriorityQueue<>();
pq.add(new Pair(1, 10));  // Node 1 with distance 10
pq.add(new Pair(1, 5));   // Node 1 with distance 5 (better path found)
// Both entries exist! Will process node 1 twice unnecessarily
```

#### 2. **Inefficient Remove Operation**
```java
// O(n) time complexity for removal
pq.remove(new Pair(node, oldDist)); // Linear search through heap
```

#### 3. **Memory Wastage**
- Keeps outdated entries that will never be optimal
- Can lead to processing same node multiple times
- Heap grows larger than necessary

#### 4. **Performance Degradation**
```java
// Without removing old entries:
while (!pq.isEmpty()) {
    Pair p = pq.poll();
    if (p.dist > dist[p.node]) continue; // Skip outdated entry
    // This check happens frequently, wasting cycles
}
```

## ✅ Why TreeSet is Superior

### 1. **🔎 In contrast, with TreeSet
TreeSet is a balanced BST and can remove an element in O(log V) if you give it the exact object.
That’s why in TreeSet we can safely do:**
```java
set.remove(new Pair(v, dist[v]));
set.add(new Pair(v, newDist));
```

### 2. **Efficient Remove Operation**
```java
// O(log n) time complexity for removal
set.remove(new Pair(node, oldDist)); // Binary search in balanced tree
```

### 3. **Memory Efficient**
- Always contains at most V entries (one per vertex)
- No outdated entries cluttering the structure
- Clean state management

### 4. **Deterministic Ordering**
```java
// Custom comparator ensures consistent ordering
TreeSet set = new TreeSet<>((a, b) -> {
    if (a.dist != b.dist) return a.dist - b.dist; // Sort by distance
    return a.node - b.node; // Break ties by node ID
});
```

### 5. **No Stale Entry Processing**
```java
// No need for staleness checks
while (!set.isEmpty()) {
    Pair p = set.pollFirst(); // Always gets the current best
    // No need to check if p.dist > dist[p.node]
}
```

## 📊 Performance Comparison

| Operation | Queue | PriorityQueue | TreeSet |
|-----------|-------|---------------|---------|
| **Insert** | O(1) | O(log n) | O(log n) |
| **Extract Min** | O(1) ❌ *wrong order* | O(log n) | O(log n) |
| **Remove Specific** | O(n) | O(n) | O(log n) ✅ |
| **Find Min** | O(1) ❌ *wrong element* | O(1) | O(log n) |
| **Duplicates** | Allowed ❌ | Allowed ❌ | Not Allowed ✅ |
| **Memory** | O(n) | O(n) + stale entries | O(V) clean |
