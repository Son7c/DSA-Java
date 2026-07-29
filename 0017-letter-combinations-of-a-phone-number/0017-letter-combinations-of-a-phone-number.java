class Solution {
    public void f(int i,StringBuilder sb,String arr[],List<String> ans,String digits){
        if(i==digits.length()){
            ans.add(sb.toString());
            return;
        }
        String str=arr[digits.charAt(i)-'0'];
        for(int j=0;j<str.length();j++){
            char ch=str.charAt(j);
            sb.append(ch);
            f(i+1,sb,arr,ans,digits);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        String arr[] ={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        f(0,sb,arr,ans,digits);
        return ans;
    }
}