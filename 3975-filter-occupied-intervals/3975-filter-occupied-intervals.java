class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] intervals, int freeStart, int freeEnd) {
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        List<int[]> list=new ArrayList<>();
        list.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            if(list.get(list.size()-1)[1]+1>=intervals[i][0]){
                list.get(list.size()-1)[1]=Math.max(list.get(list.size()-1)[1],intervals[i][1]);
            }else{
                list.add(intervals[i]);
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            int l=list.get(i)[0];
            int r=list.get(i)[1];

            //No overlap
            if(r<freeStart||l>freeEnd){
                ans.add(new ArrayList<>(Arrays.asList(l,r)));
                continue;
            }
            //left side remaining
            if(l<freeStart){
                ans.add(new ArrayList<>(Arrays.asList(l,freeStart-1)));
            }
            //right side remaining
            if(r>freeEnd){
                ans.add(new ArrayList<>(Arrays.asList(freeEnd+1,r)));
            }
        }
        return ans;
    }
}