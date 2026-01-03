class Solution {
    public int maxProfit(int[] prices) {
        int left=0,right,ans=0;
        for(right=1;right<prices.length;right++){
            int trade=prices[right]-prices[left];
            while(prices[left]>prices[right]){
                left++;
            }
            ans=Math.max(ans,trade);
        }
        return ans;
    }
}