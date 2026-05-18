class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> path=new ArrayList<>();
        h(0,s,res,path);
        return res;
    }
    public void h(int idx,String s,List<List<String>> res,List<String> path){
        if(idx==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s,idx,i)){
                path.add(s.substring(idx,i+1));
                h(i+1,s,res,path);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s,int left,int right){
        while(left<=right){
            if(s.charAt(left++)!=s.charAt(right--)) return false;
        }
        return true;
    }
}