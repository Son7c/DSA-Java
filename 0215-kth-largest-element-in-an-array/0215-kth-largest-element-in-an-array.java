class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i:nums){
            if(!pq.isEmpty()&&pq.peek()<i){
                if(pq.size()==k){
                    pq.poll();
                    pq.add(i);
                }else{
                    pq.add(i);
                }
            }else if(pq.isEmpty()||pq.size()<k){
                pq.add(i);
            }
        }
        return pq.peek();
    }
}