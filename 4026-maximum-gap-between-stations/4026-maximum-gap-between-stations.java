class Solution {
    public int maximumGap(String skill, String station) {
        int n=skill.length(),m=station.length();
        int i=0;
        int[] left=new int[n];
        int[] right=new int[n];
        for(int j=0;j<m&&i<n;j++){
            if(station.charAt(j)==skill.charAt(i)){
                left[i]=j;
                i++;
            }
        }
        i=n-1;
        for(int j=m-1;j>=0&&i>=0;j--){
            if(station.charAt(j)==skill.charAt(i)){
                right[i]=j;
                i--;
            }
        }
        int ans=0;
        for(int j=1;j<n;j++){
            ans=Math.max(ans,right[j]-left[j-1]);
        }
        return ans;
    }
}