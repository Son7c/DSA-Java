class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i:hand){
            if(!map.containsKey(i)) pq.add(i);
            map.put(i,map.getOrDefault(i,0)+1);
        }
        while(!map.isEmpty()){
            int first=pq.peek();
            for(int i=first;i<first+groupSize;i++){
                if(!map.containsKey(i)) return false;
                map.put(i,map.get(i)-1);
                if(map.get(i)==0){
                    map.remove(i);
                    if(!pq.isEmpty()&& i==pq.peek()) pq.remove();
                }
            }
        }
        return true;
    }
}