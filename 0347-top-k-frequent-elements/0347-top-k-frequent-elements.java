class Pair implements Comparable<Pair>{
    int num,count;
    public Pair(int n,int c){
        this.num=n;
        this.count=c;
    }
    @Override
    public int compareTo(Pair p2){
        return p2.count-this.count;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        for(int key:hm.keySet()){
            pq.add(new Pair(key,hm.get(key)));
        }
        int arr[]=new int[k];
        int i=0;
        while(k>0){
            arr[i++]=pq.poll().num;
            k--;
        }
        return arr;
    }
}