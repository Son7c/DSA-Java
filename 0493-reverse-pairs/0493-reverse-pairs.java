class Solution {
    private int merge(int[] nums, int low, int mid, int high) {
        int count = 0;
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[i] >(2 * (long)nums[j]))
                j++;
            count += j - (mid + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        int i = low;
        j = mid + 1;
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j])
                list.add(nums[i++]);
            else
                list.add(nums[j++]);
        }
        while (i <= mid)
            list.add(nums[i++]);
        while (j <= high)
            list.add(nums[j++]);
        for (i = 0; i < list.size(); i++) {
            nums[low+i] = list.get(i);
        }
        return count;
    }

    private int mergeSort(int[] nums, int low, int high) {
        if (low >= high)
            return 0;
        int count = 0;
        int mid = low + ((high - low) / 2);
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += merge(nums, low, mid, high);
        return count;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}