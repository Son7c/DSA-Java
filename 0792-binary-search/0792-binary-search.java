class Solution {
    public int binary(int left, int right, int nums[], int target) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                return binary(left, mid - 1, nums, target);
            }
            if (nums[mid] < target) {
                return binary(mid+1, right, nums, target);
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        return binary(0, nums.length - 1, nums, target);

    }
}