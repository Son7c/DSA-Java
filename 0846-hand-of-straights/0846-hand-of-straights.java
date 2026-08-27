class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i:hand){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        while(!map.isEmpty()){
            int first=map.firstKey();
            for(int i=first;i<first+groupSize;i++){
                if(!map.containsKey(i)) return false;
                map.put(i,map.get(i)-1);
                if(map.get(i)==0) map.remove(i);
            }
        }
        return true;
    }
}