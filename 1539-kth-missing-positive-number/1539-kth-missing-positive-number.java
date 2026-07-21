class Solution {
    public int findKthPositive(int[] arr, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:arr) set.add(i);
        int i=1,c=0;
        while(true){
            if(!set.contains(i)){
                c++;
            }
            if(c==k) return i;
            i++;
        }
    }
}