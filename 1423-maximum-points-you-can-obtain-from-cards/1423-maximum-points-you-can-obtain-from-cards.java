class Solution {
    public int f(int[] cardPoints,int k){
        int sum=0,left=0,n=cardPoints.length,min=Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            sum+=cardPoints[i];
        }
        min=sum;
        for(int right=k;right<n;right++){
            sum+=cardPoints[right];
            sum-=cardPoints[left];
            left++;
            min=Math.min(min,sum);
        }
        return min;
    }
    public int maxScore(int[] cardPoints, int k) {
        int total=0,n=cardPoints.length;
        for(int i:cardPoints){
            total+=i;
        }
        int min=f(cardPoints,n-k);
        return total-min;
    }
}