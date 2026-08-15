class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k)
            return "0";
        Stack<Integer> st = new Stack<>();
        int n = num.length();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && k > 0 && st.peek() > num.charAt(i) - '0') {
                st.pop();
                k--;
            }
            st.push(num.charAt(i) - '0');
        }
        while (!st.isEmpty() && k > 0) {
            st.pop();
            k--;
        }
        if (st.isEmpty())
            return "0";
        StringBuilder ans=new StringBuilder();
        boolean zero=true;
        for (int i : st) {
            if(zero&&i==0) continue;
            zero=false;
            ans.append(i);
        }
        return ans.length()!=0?ans.toString():"0";
    }
}