class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap <Character,Integer> hm1=new HashMap<>();
        HashMap <Character,Integer> hm2=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
            hm1.put(ch,hm1.getOrDefault(ch,0)+1);
        }
        int left=0,right=s1.length()-1;
        for(;right<s2.length();right++){
            for(int i=left;i<=right;i++){
                hm2.put(s2.charAt(i),hm2.getOrDefault(s2.charAt(i),0)+1);
            }
            if(hm1.equals(hm2))return true;
            hm2.clear();
            left++;
        }
        return false;
    }
}