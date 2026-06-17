class Solution {
    void f(int i, int target, int[] nums, List<Integer> path, List<List<Integer>> list, Set<List<Integer>> set) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(path);
            if (!set.contains(temp)) {
                list.add(temp);
                set.add(temp);
            }
            return;
        }
        if (i == 0) {
            if (target%nums[0] == 0) {
                path.add(nums[i]);
                f(i, target - nums[i], nums, path, list, set);
                path.remove(path.size()-1);
            } else {
                return;
            }
        }
        if (i < 0)
            return;
        //notPick
        f(i - 1, target, nums, path, list, set);
        //pick
        if (nums[i] <= target) {
            path.add(nums[i]);
            f(i, target - nums[i], nums, path, list, set);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(candidates);
        f(candidates.length - 1, target, candidates, path, list, set);
        return list;
    }
}