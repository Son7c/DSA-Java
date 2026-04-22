class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] nge=new int[n];
        int[] lge=new int[n];
        nge[n-1]=-1;
        int max=height[n-1];
        for(int i=n-2;i>=0;i--){
            if(height[i]>=max){
                nge[i]=-1;
                max=height[i];
            }else{
                nge[i]=max;
            }
        }
        lge[0]=-1;
        max=height[0];
        for(int i=1;i<n;i++){
            if(height[i]>=max){
                lge[i]=-1;
                max=height[i];
            }else{
                lge[i]=max;
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(lge[i]==-1||nge[i]==-1) continue;
            else{
                int y=Math.min(nge[i],lge[i]);
                ans+=y-height[i];
            }
        }
        return ans;
    }
}