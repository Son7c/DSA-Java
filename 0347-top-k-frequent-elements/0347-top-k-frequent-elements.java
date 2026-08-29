class Solution {
    class Pair implements Comparable<Pair>{
        int val, freq;

        public Pair(int _v, int _f) {
            val = _v;
            freq = _f;
        }

        public int compareTo(Pair p2) {
            return p2.freq - this.freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:map.keySet()){
            pq.add(new Pair(i,map.get(i)));
        }
        int[] ans=new int[k];
        int idx=0;
        while(!pq.isEmpty()&&idx!=k){
            ans[idx++]=pq.poll().val;
        }
        return ans;
    }
}