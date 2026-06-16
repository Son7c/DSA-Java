class Solution {
    public int findContentChildren(int[] g, int[] s) {
       Arrays.sort(g);
       Arrays.sort(s);
       int left=0,right=0;
       int m=g.length,n=s.length,count=0;
       while(left<m&&right<n){
        if(s[right]>=g[left]){
            left++;
            right++;
            count++;
        }else{
            right++;
        }
       } 
       return count;
    }
}