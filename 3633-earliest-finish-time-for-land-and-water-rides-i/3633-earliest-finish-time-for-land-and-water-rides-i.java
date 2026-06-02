class Solution {
    private int calc(int[]firstStart,int[]firstDuration,int[]secondStart,int[]secondDuration){
        int minFinish=Integer.MAX_VALUE,ans=Integer.MAX_VALUE;
        for(int i=0;i<firstStart.length;i++){
            minFinish=Math.min(minFinish,firstStart[i]+firstDuration[i]);
        }
        //try every possibility of second ride
        for(int i=0;i<secondStart.length;i++){
            int startTime=Math.max(minFinish,secondStart[i]);
            ans=Math.min(ans,startTime+secondDuration[i]);
        }
        return ans;
    }
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int landFirst=calc(landStartTime,landDuration,waterStartTime,waterDuration);
        int waterFirst=calc(waterStartTime,waterDuration,landStartTime,landDuration);
        return Math.min(landFirst,waterFirst);
    }
}