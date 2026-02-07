class Solution {
    public String removeOuterParentheses(String s) {
        int count=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                count++;
            }else if(ch==')'){
                count--;
            }
            if((count==1&&ch=='(')||count==0){
                continue;
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}