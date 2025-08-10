class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(String str:tokens){
            if(str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")){
                int res=applyOp(str,st);
                st.push(res);
            }else{
                int num=Integer.parseInt(str);
                st.push(num);
            }
        }
        return(st.pop());
    }
    public int applyOp(String str,Stack<Integer> st){
        int a=st.pop();
        int b=st.pop();
        switch(str){
            case "+": return a+b;
            case "-": return b-a;
            case "/": return b/a;
            case "*":return a*b;
            default:return -1;
        }
    }
}