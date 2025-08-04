class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),0);
        }
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.get(s.charAt(i))+1);
        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(hm.get(ch)!=null){
                if(hm.get(ch)==1){
                    hm.remove(ch);
                }else{
                    hm.put(ch,hm.get(ch)-1);
                }
            }else{
                return false;
            }
        }
        return hm.isEmpty();
    }
}