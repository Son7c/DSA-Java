class Solution {
    public boolean f(int i,String s,HashSet<String> set,Boolean[] dp){
        if(i==s.length()){
            return true;
        }
        if(dp[i]!=null) return dp[i];
        if(set.contains(s)) return true;
        for(int j=i+1;j<=s.length();j++){
            String temp=s.substring(i,j);
            if(set.contains(temp)&&f(j,s,set,dp)) return dp[i]= true;
        }
        return dp[i]=false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<wordDict.size();i++){
            set.add(wordDict.get(i));
        }
        Boolean[] dp=new Boolean[s.length()];
        return f(0,s,set,dp);
    }
}