class Solution {
    public boolean f(int n,int k,int stones[],HashSet<Integer> hs,HashMap<String,Boolean> hm){
        String key=n + "," + k;
        if(n==stones[stones.length-1]) return true;
        if(!hs.contains(n)) return false;
        if(n>stones[stones.length-1]||k<=0||n<0) return false;
        if(hm.containsKey(key)) return hm.get(key);

        boolean one=f(n+k-1,k-1,stones,hs,hm);
        boolean two=f(n+k,k,stones,hs,hm);
        boolean three=f(n+k+1,k+1,stones,hs,hm);
        boolean res=one||two||three;

        hm.put(key,res);
        return res;
    }
    public boolean canCross(int[] stones) {
        HashSet<Integer> hs=new HashSet<>();
        HashMap<String,Boolean> hm=new HashMap<>();
        for(int i:stones){
            hs.add(i);
        }
        return f(1,1,stones,hs,hm);
    }
}