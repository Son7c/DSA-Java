class Solution {
    public int passwordStrength(String password) {
        int lower = 0, upper = 0, digit = 0, spec = 0;
        HashSet<Character> map = new HashSet<>();
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (!map.contains(ch)) {

                if (ch >= 'a' && ch <= 'z')
                    lower += 1;
                else if (ch >= 'A' && ch <= 'Z')
                    upper += 2;
                else if (Character.isDigit(ch))
                    digit += 3;
                else
                    spec += 5;
                map.add(ch);
            }
        }
        return lower + upper + digit + spec;
    }
}