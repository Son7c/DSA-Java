class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==1) return stones[0];
        PriorityQueue <Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        while(pq.size()!=1&&!pq.isEmpty()){
            int val=pq.remove()-pq.remove();
            if(val==0) pq.add(0);
            else{
                pq.add(Math.abs(val));
            }
        }
        return pq.peek();
    }
}