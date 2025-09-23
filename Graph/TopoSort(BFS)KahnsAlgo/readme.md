<img width="547" height="342" alt="image" src="https://github.com/user-attachments/assets/c5b637d7-e609-4855-aca8-0c92526e2c09" />
Approach: 

Previously, we solved this question using the DFS traversal technique. But in this article,  we will apply the BFS(Breadth First Search) traversal technique. Breadth First Search or BFS is a traversal technique where we visit the nodes level-wise, i.e., it visits the same level nodes simultaneously, and then moves to the next level.

Initial Configuration:

Indegree Array: Initially all elements are set to 0. Then, We will count the incoming edges for a node and store it in this array. For example, if indegree of node 3 is 2, indegree[3] = 2.

Queue: As we will use BFS, a queue is required. Initially, the node with indegree 0 will be pushed into the queue.

Answer array: Initially empty and is used to store the linear ordering.

The algorithm steps are as follows:

First, we will calculate the indegree of each node and store it in the indegree array. We can iterate through the given adj list, and simply for every node u->v, we can increase the indegree of v by 1 in the indegree array. 
Initially, there will be always at least a single node whose indegree is 0. So, we will push the node(s) with indegree 0 into the queue.
Then, we will pop a node from the queue including the node in our answer array, and for all its adjacent nodes, we will decrease the indegree of that node by one. For example, if node u that has been popped out from the queue has an edge towards node v(u->v), we will decrease indegree[v] by 1.
After that, if for any node the indegree becomes 0, we will push that node again into the queue.
We will repeat steps 3 and 4 until the queue is completely empty. Finally, completing the BFS we will get the linear ordering of the nodes in the answer array.
Let’s understand how to find the indegree(s):

By visiting the adjacency list, we can find out the indegrees for each node. For example, if node 3 is an adjacent node of node 2, we will just increase indegree[3] by 1 as the adjacency list suggests that node 3 has an incoming edge from node 2.
