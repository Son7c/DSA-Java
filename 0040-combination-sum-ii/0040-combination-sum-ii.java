class Solution {
    public void h(int idx, List<List<Integer>> res, List<Integer> path, int[] nums, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if(i>idx&&nums[i]==nums[i-1]){
                continue;
            }
            if (nums[i] > target)
                break;
            path.add(nums[i]);
            h(i + 1, res, path, nums, target - nums[i]);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        h(0, res, path, nums, target);
        return res;
    }
}