class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0, m = nums1.length, n = nums2.length;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j])
                list.add(nums1[i++]);
            else list.add(nums2[j++]);
        }
        while(i<m) list.add(nums1[i++]);
        while(j<n) list.add(nums2[j++]);
        int x=list.size();
        double ans=0;
        if(x%2==0) ans=(double) (list.get((x/2)-1)+list.get(x/2))/2;
        else ans=(double) list.get(x/2);
        return ans;
    }
}