class Solution {
    public int beautySum(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            int[] freq=new int[26];
            
            for(int j=i;j<s.length();j++){
                char ch=s.charAt(j);
                freq[ch-'a']++;
                int maxi=Integer.MIN_VALUE;
                int mini=Integer.MAX_VALUE;
                for(int f:freq){
                    if(f>0){
                        mini=Math.min(mini,f);
                        maxi=Math.max(maxi,f);
                    }

                }
                ans+=maxi-mini;
            }
        }
        return ans;
    }
}