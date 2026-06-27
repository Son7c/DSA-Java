class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        int n=nums.length;
        int[]res=new int[n-k+1];
        
        for(int i=0;i<k;i++){
            while(!dq.isEmpty()&&nums[i]>nums[dq.peekLast()]) dq.pollLast();
            dq.addLast(i);
        }
        res[0]=nums[dq.peekFirst()];
        for(int i=k;i<n;i++){
            if(dq.peekFirst()<i-k+1) dq.pollFirst();
            while(!dq.isEmpty()&&nums[i]>nums[dq.peekLast()])
            dq.pollLast();
            
            dq.addLast(i);
            
            res[i-k+1]=nums[dq.peekFirst()];
        }
        return res;
    }
}