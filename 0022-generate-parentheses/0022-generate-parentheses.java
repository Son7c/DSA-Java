class Solution {
    public boolean isValid(StringBuilder sb){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='(') st.push(')');
            else{
                if(st.isEmpty()) return false;
                if(sb.charAt(i)!=st.pop()) return false;
            }
        }
        return st.isEmpty();
    }
    public void f(StringBuilder sb,int n,List<String> list){
        if(sb.length()==2*n){
            if(isValid(sb)) list.add(sb.toString()); 
            return;
        }
        sb.append('(');
        f(sb,n,list);
        sb.deleteCharAt(sb.length()-1);
        sb.append(')');
        f(sb,n,list);
        sb.deleteCharAt(sb.length()-1);
    }
    public List<String> generateParenthesis(int n) {
        StringBuilder sb=new StringBuilder();
        List<String> list=new ArrayList<>();
        f(sb,n,list);
        return list;
    }
}