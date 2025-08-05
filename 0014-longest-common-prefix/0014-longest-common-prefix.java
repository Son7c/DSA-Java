class Solution {
    public String longestCommonPrefix(String[] strs) {
        String str=strs[0];
        for(int i=1;i<strs.length;i++){
            int j=0;
            while(j<Math.min(str.length(),strs[i].length())){
                if(str.charAt(j)!=strs[i].charAt(j)){
                    break;
                }
                j++;
            }
            str=str.substring(0,j);
        }
        return str;
    }
}