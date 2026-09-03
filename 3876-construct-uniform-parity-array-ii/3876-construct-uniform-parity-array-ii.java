class Solution {
    public boolean uniformArray(int[] nums1) {
        int min=Integer.MAX_VALUE,n=nums1.length;
        for(int i:nums1){
            min=Math.min(i,min);
        }
        //odd
        int i=0;
        while(i<n){
            if(nums1[i]%2!=0) i++;
            else if(min==nums1[i]){
                if(min%2==0) break;
                i++;
            }
            else if((nums1[i]-min)%2!=0&&(nums1[i]-min)>=1) i++;
            else break;
        }
        if(i==n) return true;

        i=0;
        //even
        while(i<n){
            if(nums1[i]%2==0) i++;
            else if(min==nums1[i]){
                if(min%2!=0) break;
                i++;
            }
            else if((nums1[i]-min)%2==0&&nums1[i]-min>=1) i++;
            else break;
        }
        if(i==n) return true;
        return false;
    }
}