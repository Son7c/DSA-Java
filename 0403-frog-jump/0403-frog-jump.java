class Solution {
    public boolean check(int[] stones,int n,int end,HashSet <Integer> hs,int jump,HashMap <String,Boolean> memo){
        String key=n + "," + jump;
        if(memo.containsKey(key)) return memo.get(key);
        if(n==end) return true;
        if(n>end||n<0||jump<=0) return false;
        if(!hs.contains(n)){
            return false;
        }
        boolean a=check(stones,n+jump-1,end,hs,jump-1,memo);
        boolean b=check(stones,n+jump,end,hs,jump,memo);
        boolean c=check(stones,n+jump+1,end,hs,jump+1,memo);
        boolean res=a||b||c;
        memo.put(key,res);
        return res;
    }
    public boolean canCross(int[] stones) {
        if(stones.length > 1 && stones[1] != 1) return false;

        int end=stones[stones.length-1];
        
        HashSet <Integer> hs=new HashSet<>();
        HashMap <String,Boolean> memo=new HashMap<>();
        for(int i=0;i<stones.length;i++){
            hs.add(stones[i]);
        }
        return check(stones,1,end,hs,1,memo);
    }
}