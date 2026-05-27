class Solution {
    public int repeatedStringMatch(String a, String b) {
        int ans=1;
        StringBuilder sb=new StringBuilder(a);
        while(sb.length()<b.length()){
            sb.append(a);
            ans++;
        }
        if(sb.toString().contains(b)) return ans;
        sb.append(a);
        ans++;
        if(sb.toString().contains(b)) return ans;
        return -1;
    }
}