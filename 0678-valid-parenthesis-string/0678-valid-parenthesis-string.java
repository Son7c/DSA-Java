class Solution {
    public boolean checkValidString(String s) {
        int min = 0, max = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                min += 1;
                max += 1;
            } else if (ch == ')') {
                min -= 1;
                max -= 1;
            } else {
                min -= 1;
                max += 1;
            }
            if (min < 0)
                min = 0;
            if (max < 0)
                return false;
        }
        return min == 0;
    }
}