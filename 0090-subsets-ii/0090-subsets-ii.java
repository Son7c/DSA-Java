class Solution {
    void f(int i,int[]nums,List<Integer> path,List<List<Integer>> ans,Set<List<Integer>> set){
        if(i==nums.length){
            if(!set.contains(path)){
                List<Integer> temp=new ArrayList<>(path);
                ans.add(new ArrayList<>(temp));
                set.add(temp);
            }
            return;
        }
        //not take
        f(i+1,nums,path,ans,set);
        //take
        path.add(nums[i]);
        f(i+1,nums,path,ans,set);
        path.remove(path.size()-1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set=new HashSet<>();
        List<Integer> path=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        f(0,nums,path,ans,set);
        return ans;
    }
}