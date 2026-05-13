class Solution {
    public int f(int[] nums, int k){
        int left=0,count=0,ans=0,n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int right=0;right<n;right++){
            if(!map.containsKey(nums[right])){
                count++;
            }
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(count==k){
                ans+=n-right;
                map.put(nums[left],map.getOrDefault(nums[left],0)-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                    count--;
                }
                left++;
            }
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return f(nums,k)-f(nums,k+1);
    }
}