class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i=0,n=intervals.length;
        List<int[]> list=new ArrayList<>();
        while(i<n&&intervals[i][1]<newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        while(i<n&&intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        list.add(newInterval);
        while(i<n){
            list.add(intervals[i]);
            i++;
        }
        int[][] res=new int[list.size()][2];
        list.toArray(res);
        return res;
    }
}