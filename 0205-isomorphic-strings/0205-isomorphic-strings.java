class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<>();
        HashSet<Character> set=new HashSet<>();
        int left=0,right=0;
        while(left!=s.length()&&right!=t.length()){
            char c1=s.charAt(left);
            char c2=t.charAt(right);

            if(map.containsKey(c1)){
                if(map.get(c1)!=c2) return false;
            }else{
                if(!set.contains(c2)){
                    map.put(c1,c2);
                    set.add(c2);
                    continue;
                }
                return false;
            }
            left++;
            right++;
        }
        return true;
    }
}