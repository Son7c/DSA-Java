class Solution {
    public void h(int idx, int[] nums, HashSet<List<Integer>> set, List<List<Integer>> res, List<Integer> path) {
        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            if (!set.contains(path)) {
                set.add(new ArrayList<>(path));
                res.add(new ArrayList<>(path));
            }
            h(i + 1, nums, set, res, path);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        h(0, nums, set, res, path);
        res.add(new ArrayList<>());
        return res;
    }
}