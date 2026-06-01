class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public void f(int n){
        List<Integer> temp=new ArrayList<>();
        if(n==1){
            temp.add(1);
            res.add(temp);
            return;
        }
        f(n-1);
        temp.add(1);
        List<Integer> prev=res.get(res.size()-1);
        for(int i=1;i<prev.size();i++){
            int sum=prev.get(i)+prev.get(i-1);
            temp.add(sum);
        }
        temp.add(1);
        res.add(temp);
    }
    public List<List<Integer>> generate(int n) {
        f(n);
        return res;
    }
}