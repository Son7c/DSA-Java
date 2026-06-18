class Solution {
    boolean check(String s,int l,int r){
        int left=l,right=r;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    void f(int i,String s,List<String> path,List<List<String>> res){
        if(i==s.length()) res.add(new ArrayList<>(path));
        for(int j=i;j<s.length();j++){
            if(check(s,i,j)){
                path.add(s.substring(i,j+1));
                f(j+1,s,path,res);
                path.remove(path.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> path=new ArrayList<>();
        f(0,s,path,res);
        return res;
    }
}