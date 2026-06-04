class Solution {
    public int waviness(int num){
        if(num<100) return 0;
        String str=Integer.toString(num);
        int ans=0;
        for(int i=1;i<str.length()-1;i++){
            if(str.charAt(i)-'0'>str.charAt(i-1)-'0'&&str.charAt(i)-'0'>str.charAt(i+1)-'0') ans++;
            else if(str.charAt(i)-'0'<str.charAt(i-1)-'0'&&str.charAt(i)-'0'<str.charAt(i+1)-'0') ans++;
        }
        return ans;
    }
    public int totalWaviness(int num1, int num2) {
        int ans=0;
        for(int i=num1;i<=num2;i++){
            ans+=waviness(i);
        }
        return ans;
    }
}