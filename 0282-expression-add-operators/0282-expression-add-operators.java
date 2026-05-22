class Solution {
    private List<String> ans = new ArrayList<>();

    public void dfs(int idx, String path, String num, int target, long res, long prev) {
        if (idx == num.length()) {
            if (res == target) {
                ans.add(path);
                return;
            }
        }
        for (int i = idx; i < num.length(); i++) {
            if (i != idx && num.charAt(idx) == '0')
                break;
            String s = num.substring(idx, i + 1);
            long curr = Long.parseLong(s);
            if (idx == 0) {
                dfs(i + 1, path + s, num, target, curr, curr);
            } else {
                dfs(i + 1, path + "+" + s, num, target, res + curr, curr);
                dfs(i + 1, path + "-" + s, num, target, res - curr, -curr);
                dfs(i + 1, path + "*" + s, num, target, res - prev + (prev * curr), prev * curr);
            }
        }
    }

    public List<String> addOperators(String num, int target) {
        dfs(0, "", num, target, 0, 0);
        return ans;
    }
}