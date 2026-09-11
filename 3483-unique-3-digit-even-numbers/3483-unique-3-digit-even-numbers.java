class Solution {
    public int totalNumbers(int[] digits) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int i:digits){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i=100;i<1000;i+=2){
            int n=i;
            HashMap<Integer,Integer> temp=new HashMap<>();
            while(n>0){
                temp.put(n%10,temp.getOrDefault(n%10,0)+1);
                n=n/10;
            }
            boolean possible=true;
            for(int x:temp.keySet()){
                if(!map.containsKey(x)||map.get(x)<temp.get(x)){
                    possible=false;
                    break;
                }
            }
            if(possible) count++;
        }
        return count;
    }
}