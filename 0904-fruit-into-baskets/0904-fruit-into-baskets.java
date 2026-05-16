class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        if (n == 1 || n == 2)
            return n;
        int left = 0, ans = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < n; right++) {

            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() >2 ) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left+1);

        }
        return ans;
    }
}