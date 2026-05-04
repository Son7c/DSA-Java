class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st=new Stack<>();
        st.push(num.charAt(0)-'0');
        int count=0;
        for(int i=1;i<num.length();i++){
            int digit=num.charAt(i)-'0';
            while(!st.isEmpty()&&st.peek()>digit){
                if(count==k){
                    break;
                }
                st.pop();
                count++;
            }
            st.push(num.charAt(i)-'0');
        }
        while(!st.isEmpty()&&count!=k){
            st.pop();
            count++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i:st){
            sb.append(i);
        }
        int idx=0;
        while(idx<sb.length()&&sb.charAt(idx)=='0') idx++;
        String result=sb.substring(idx);
        return result.length()==0?"0":result;
    }
}