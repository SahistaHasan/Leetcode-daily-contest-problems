class Solution {
    List<List<Integer>> list=new ArrayList<>();
    public void recurse(int index,int[] nums, boolean [] vis, List<Integer> inner){
        if(inner.size()==nums.length){
            list.add(new ArrayList<>(inner));
            return;
        }
        
       int i=0;
        while(i<nums.length){
            while(i!=0 && i<nums.length && nums[i]==nums[i-1] && !vis[i - 1]){
                i++;
                
            }
            if(i<nums.length && vis[i]==false){
                vis[i]=true;
                inner.add(nums[i]);
                recurse(i,nums,vis,inner);
                inner.remove(inner.size()-1);
                vis[i]=false;
            }
            i++;
        }
      
        
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> inner = new ArrayList<>();
        boolean [] vis=new boolean [nums.length];
        recurse(0,nums,vis,inner);
        return list;
    }
}
