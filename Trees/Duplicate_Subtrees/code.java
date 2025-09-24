class Solution {
      List<TreeNode> res= new ArrayList<>();
      Map<String,Integer> map = new HashMap<>();
    public String postorder(TreeNode root){
       if(root==null){
        return "#";
       }
       StringBuilder curr= new StringBuilder();
      String left= postorder(root.left);
      String right = postorder(root.right);
      curr.append(root.val);
      curr.append(",");
      curr.append(left);
      curr.append(",");
      curr.append(right);
      map.put(curr.toString(),map.getOrDefault(curr.toString(),0)+1);
      if(map.get(curr.toString())==2){
        res.add(root);
      }
      
      return curr.toString();


    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
      
        StringBuilder sb = new StringBuilder();
        postorder(root);
        return res;
    }
}
