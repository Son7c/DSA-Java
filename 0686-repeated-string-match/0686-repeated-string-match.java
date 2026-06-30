class Solution {
    public int repeatedStringMatch(String a, String b) {
        if(a.contains(b)) return 1;
        StringBuilder sb=new StringBuilder(a);
        int count=1;
        while(sb.length()<=b.length()){
            count++;
            sb.append(a);
            if(sb.toString().contains(b)) return count;
        }
        sb.append(a);
        if(sb.toString().contains(b)) return count+1;
        return -1;
    }
}