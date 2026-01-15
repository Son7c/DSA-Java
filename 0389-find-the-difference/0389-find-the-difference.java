class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(hm.get(ch)==1){
                hm.remove(ch);
            }else{
                hm.put(ch,hm.get(ch)-1);
            }
        }
        for(Character ch : hm.keySet()){
            return ch;
        }
        return ' ';
    }
}