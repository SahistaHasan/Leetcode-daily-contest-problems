1️⃣ Goal

We want to check if a graph is bipartite, meaning we can color its nodes using two colors (say 0 and 1) such that:

No two connected nodes share the same color.

2️⃣ Coloring Strategy

Start with any uncolored node (root of a component) and assign it a color (say 0).

Use DFS to visit all its neighbors:

If a neighbor is uncolored, assign it the opposite color of the current node.

If a neighbor is already colored, check if it has a different color:

If yes → fine, continue.

If no → conflict → the graph is not bipartite.
