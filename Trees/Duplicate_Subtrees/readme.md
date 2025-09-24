652. Find Duplicate Subtrees

Medium



Given the root of a binary tree, return all duplicate subtrees.

For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with the same node values.

 <img width="561" height="441" alt="image" src="https://github.com/user-attachments/assets/6d6461fa-a4b2-4f95-b071-17820643268f" />
 
 <h1>Tip-Serialize everything..! </h1>

 ⚠️ Without "#"

Take these two trees:

<img width="341" height="179" alt="image" src="https://github.com/user-attachments/assets/0e438373-433b-47df-83dd-686c17e1b712" />


Left child vs. right child.

Without null markers, both serialize to "12".

Ambiguity: they look the same, even though they’re structurally different.

✅ With "#"

Let’s add "#" for nulls:

First tree serialization:

1,2,#,#,#


Second tree serialization:

1,#,2,#,#


Now they are different strings → the algorithm can tell the structures apart.
Example of the problem

<img width="161" height="492" alt="image" src="https://github.com/user-attachments/assets/8821db3c-cf5f-4765-8df8-7e98bb3d5177" />



Both could serialize to "123" with your approach, so duplicates get misdetected.

Fix: Add separators and null markers

Instead of:

curr.append(root.val);
curr.append(left);
curr.append(right);


Do:

curr.append(root.val).append(",")
    .append(left).append(",")
    .append(right);


and when root == null, return "#". This way, every subtree has a unique serialization.
