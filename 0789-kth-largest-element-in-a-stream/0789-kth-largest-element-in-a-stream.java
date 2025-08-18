class KthLargest {
    PriorityQueue<Integer> pq=new PriorityQueue<>();
    int size=0;
    public KthLargest(int k, int[] nums) {
        size=k;
        for(int i=0;i<nums.length;i++){
            if(pq.size()==k&&pq.peek()<nums[i]){
                pq.remove();
                pq.add(nums[i]);
            }else if(pq.size()==k&&pq.peek()>nums[i]) continue;
            else{
                pq.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        if(pq.size()==size&&pq.peek()<val){
            pq.remove();
            pq.add(val);
        }
        else if(pq.size()<size){
            pq.add(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */