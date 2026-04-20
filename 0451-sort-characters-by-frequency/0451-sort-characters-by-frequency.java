class Pair implements Comparable<Pair>{
    char ch;
    int freq;
    public Pair(char c,int f){
        this.ch=c;
        this.freq=f;
    }
    @Override
    public int compareTo(Pair p2){
        return p2.freq-this.freq;
    }
}
class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(Character ch:map.keySet()){
            pq.add(new Pair(ch,map.get(ch)));
        }
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            for(int i=0;i<map.get(p.ch);i++){
                sb.append(p.ch);
            }
        }
        return sb.toString();
    }
}