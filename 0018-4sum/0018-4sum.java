class Solution {
    HashSet<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            List<Integer> res = new ArrayList<>();
            res.add(nums[i]);
            threeSum(i + 1, nums, target - nums[i], res, list);
        }
        return list;
    }

    public void threeSum(int idx, int[] nums, long target, List<Integer> res, List<List<Integer>> list) {

        for (int i = idx; i < nums.length - 2; i++) {
            res.add(nums[i]);
            twoSum(i + 1, nums, target - nums[i], res, list);
            res.remove(res.size() - 1);
        }
    }

    public void twoSum(int idx, int[] nums, long target, List<Integer> res, List<List<Integer>> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = idx; i < nums.length; i++) {
            long complement = target - nums[i];
            if (complement >= Integer.MIN_VALUE &&
                    complement <= Integer.MAX_VALUE &&
                    map.containsKey((int) complement)) {
                res.add(nums[i]);
                res.add((int)(target - nums[i]));
                List<Integer> temp = new ArrayList<>(res);
                if(set.add(temp)) list.add(temp);
                res.remove(res.size() - 1);
                res.remove(res.size() - 1);
            }
            map.put(nums[i], i);
        }
    }
}