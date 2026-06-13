class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == -nums[i]) {
                    List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r]));
                    set.add(temp);
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < -nums[i])
                    l++;
                else
                    r--;
            }
        }
        return new ArrayList<>(set);
    }
}