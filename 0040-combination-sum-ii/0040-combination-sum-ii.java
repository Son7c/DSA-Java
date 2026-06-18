class Solution {
    void f(int i, int target, int[] nums, List<Integer> path, List<List<Integer>> list) {
        if(target==0){
            list.add(new ArrayList<>(path));
            return;
        }
        for(int j=i;j<nums.length;j++){
            if(j>i&&nums[j]==nums[j-1]) continue;
            if(nums[j]>target) break;
            path.add(nums[j]);
            f(j+1,target-nums[j],nums,path,list);
            path.remove(path.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        f(0, target, candidates, path, list);
        return list;
    }
}