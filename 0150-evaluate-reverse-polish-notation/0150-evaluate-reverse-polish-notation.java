class Solution {
    public int expression(String op,int a,int b){
        int result=0;
        switch(op){
            case "+":
                result=a+b;
                break;
            case "-":
                result=a-b;
                break;
            case "*":
                result=a*b;
                break;
            case "/":
                result=a/b;
                break;
            default :
                result=0;
                break;
        }
        return result;
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(String str:tokens){
            if(str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")){
                int b=st.pop();
                int a=st.pop();
                int result=expression(str,a,b);
                st.push(result);
            }else{
                st.push(Integer.parseInt(str));
            }
        }
        return st.pop();

    }
}