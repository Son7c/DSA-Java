class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        Set <List<Integer>> ans=new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int lp=i+1,rp=nums.length-1;
            while(lp<rp){
                int sum=nums[lp]+nums[rp]+nums[i];
                if(sum==0){
                    ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[lp],nums[rp])));
                    lp++;
                    rp--;
                }
                else if(sum>0) rp--;
                else lp++;
            }
        }
        return new ArrayList<>(ans);
    }
}