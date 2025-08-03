class Solution {
    public String reverseWords(String s) {
        String []arr=s.trim().split("\\s+");
        Stack <String> st=new Stack<>();
        for(String str:arr){
            if(!str.equals(" ")||!str.equals("")){
                st.push(str);
            }
        }
        System.out.println(st);
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}