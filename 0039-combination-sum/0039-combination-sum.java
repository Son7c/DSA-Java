class Solution {
    public void h(int idx,List<List<Integer>> res,List<Integer> path,int[] nums,int target,HashSet<List<Integer>> set){
        if(idx==nums.length) return;
        if(nums[idx]<target){
            path.add(nums[idx]);
            h(idx,res,path,nums,target-nums[idx],set);
            if(path.size()>0) path.remove(path.size()-1);
        }
        if(nums[idx]==target){
            path.add(target);
            if(!set.contains(path)){
                res.add(new ArrayList<>(path));
                set.add(new ArrayList<>(path));
            }
            path.remove(path.size()-1);
            h(idx+1,res,path,nums,target,set);
        }
        else {
            h(idx+1,res,path,nums,target,set);
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        HashSet<List<Integer>> set=new HashSet<>();
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            h(i,res,path,nums,target,set);
        }
        return res;
    }
}