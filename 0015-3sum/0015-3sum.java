class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            int l=i+1,r=nums.length-1;
            while(l<r){
                int sum=nums[i]+nums[l]+nums[r];
                if(sum==0){
                    List<Integer> temp=new ArrayList<>(Arrays.asList(nums[i],nums[l],nums[r]));
                    ans.add(temp);
                    l++;
                    r--;
                    while(l<r&&nums[l-1]==nums[l]) l++;
                    while(l<r&&nums[r+1]==nums[r]) r--;
                }
                else if(sum<0) l++;
                else r--;
            }   
        }
        return ans;
    }
}