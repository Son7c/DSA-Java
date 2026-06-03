class Solution {
    private int calc(int[]firstStart,int[]firstDuration,int[]secondStart,int[]secondDuration){
        int minFinish=Integer.MAX_VALUE,ans=Integer.MAX_VALUE;
        for(int i=0;i<firstDuration.length;i++){
            minFinish=Math.min(firstStart[i]+firstDuration[i],minFinish);
        }
        for(int i=0;i<secondDuration.length;i++){
            int start=Math.max(minFinish,secondStart[i]);
            ans=Math.min(ans,start+secondDuration[i]);
        }
        return ans;
    }
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int lw=calc(landStartTime,landDuration,waterStartTime,waterDuration);
        int wl=calc(waterStartTime,waterDuration,landStartTime,landDuration);
        return Math.min(lw,wl);
    }
}