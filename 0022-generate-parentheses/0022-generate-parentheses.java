class Solution {
    public void f(String res,int op,int cp,List<String> list,int n){
        if(op==n&&cp==n){
            list.add(res);
            return;
        }
        if(op<n){
            f(res+"(",op+1,cp,list,n);
        }
        if(cp<op){
            f(res+")",op,cp+1,list,n);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        f("",0,0,list,n);
        return list;
    }
}