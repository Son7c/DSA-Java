class Solution {
    public String minWindow(String s, String t) {
        int left = 0, ans = Integer.MAX_VALUE, count = 0,start=0;
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                if(map.get(ch)>0){
                    count++;
                }
                map.put(ch, map.get(ch) - 1);
            }
            while (count == t.length()) {
                if (right - left + 1 < ans) {
                    ans = right - left + 1;
                    start=left;
                }
                //Shrinking
                if (map.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    if(map.get(s.charAt(left))>0){
                        count--;
                    }
                }
                left++;
            }
        }
        return ans==Integer.MAX_VALUE?"":s.substring(start,start+ans);
    }
}