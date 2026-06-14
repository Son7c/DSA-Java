class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] nge=new int[n];
        int[] pge=new int[n];
        int max=height[n-1];
        nge[n-1]=-1;
        for(int i=n-2;i>=0;i--){
            if(height[i]>=max){
                nge[i]=-1;
                max=height[i];
            }
            else nge[i]=max;
        }
        pge[0]=-1;
        max=height[0];
        for(int i=0;i<n;i++){
            if(height[i]>=max){
                pge[i]=-1;
                max=height[i];
            }
            else pge[i]=max;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(nge[i]==-1||pge[i]==-1) continue;
            ans+=Math.min(nge[i],pge[i])-height[i];
        }
        return ans;
    }
}