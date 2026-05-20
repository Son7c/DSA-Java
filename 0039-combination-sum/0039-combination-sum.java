class Solution {
    public void h(int idx,List<List<Integer>> res,List<Integer> path,int[] nums,int target){
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            if(nums[i]>target) break;
            path.add(nums[i]);
            h(i,res,path,nums,target-nums[i]);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        Arrays.sort(nums);
        h(0,res,path,nums,target);
        return res;
    }
}