class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int n=intervals.length;
        List<int[]> ans=new ArrayList<>();
        ans.add(intervals[0]);
        for(int i=1;i<n;i++){
            int curStart=intervals[i][0];
            if(curStart<=ans.get(ans.size()-1)[1]){
                ans.get(ans.size()-1)[1]=Math.max(intervals[i][1],ans.get(ans.size()-1)[1]);
            }else{
                ans.add(intervals[i]);
            }
        }
        int[][]res=new int[ans.size()][2];
        ans.toArray(res);
        return res;
    }
}