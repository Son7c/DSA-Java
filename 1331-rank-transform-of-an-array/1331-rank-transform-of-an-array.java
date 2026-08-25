class Solution {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        int idx=1;
        while(!pq.isEmpty()){
            if(!map.containsKey(pq.peek())) map.put(pq.peek(),idx++);
            pq.poll();
        }
        int[] ans=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            ans[i]=map.get(arr[i]);
        }
        return ans;
    }
}