class Solution {
    public int minimumCost(int[] cost) {
        if(cost.length==1) return cost[0];
        if(cost.length==2) return cost[0]+cost[1];
        Arrays.sort(cost);
        int left=0,right=cost.length-1;
        while(left<right){
            int temp=cost[left];
            cost[left]=cost[right];
            cost[right]=temp;
            left++;
            right--;
        }
        int ans=0;
        for(int i=0;i<cost.length;i++){
            if((i+1)%3==0) continue;
            ans+=cost[i];
        }
        return ans;
    }
}