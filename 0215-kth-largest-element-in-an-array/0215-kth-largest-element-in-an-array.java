class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(pq.size()==k){
                if(pq.peek()>=nums[i]) continue;
                pq.poll();
            }
            pq.add(nums[i]);
        }
        return pq.peek();
    }
}