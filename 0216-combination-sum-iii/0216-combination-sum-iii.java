class Solution {
    public void h(int idx,  List<List<Integer>> res,List<Integer> path,int k,int n,int[] nums){
        if(k==0){
            if(n==0){
                res.add(new ArrayList<Integer>(path));
            }
            return;
        }
        for(int i=idx;i<nums.length;i++){
            if(nums[i]>n) break;
            path.add(nums[i]);
            h(i+1,res,path,k-1,n-nums[i],nums);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums={1,2,3,4,5,6,7,8,9};
        List<Integer> path=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        h(0,res,path,k,n,nums);
        return res;
    }
}