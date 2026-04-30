class Solution {
    public int getVal(int a, int b,String ch) {
        switch(ch){
            case "+":
                return a+b;
            case "-":
                return b-a;
            case "*":
                return a*b;
            case "/":
                return b/a;
            default:
                return -1;
        }
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String ch=tokens[i];
            if(ch.equals("+")||ch.equals("-")||ch.equals("*")||ch.equals("/")){
                int a=st.pop();
                int b=st.pop();
                st.push(getVal(a,b,ch));
            }else{
                st.push(Integer.parseInt(ch));
            }
        }
        return st.pop();
    }
}