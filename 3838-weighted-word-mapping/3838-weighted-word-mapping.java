class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb=new StringBuilder();
        for(String str:words){
            int val=0;
            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                val+=weights[ch-'a'];
            }
            val=val%26;
            char c=(char)('a'+(25-val));
            sb.append(c);
        }
        return sb.toString();
    }
}