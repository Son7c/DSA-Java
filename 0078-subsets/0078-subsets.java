class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<=(Math.pow(2,n)-1);i++){
            int mask=1;
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i&1<<j)!=0) list.add(nums[j]);
            }
            ans.add(list);
        }
        return ans;
    }
}