 class Solution {
    class Pair implements Comparable<Pair> {
        int idx, count;
        public Pair(int i, int c) {
            this.idx = i;
            this.count = c;
        }
        @Override
        public int compareTo(Pair p2) {
            return p2.count - this.count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Set<Integer> keys = map.keySet();
        for (Integer i : keys) {
            pq.add(new Pair(i, map.get(i)));
        }

        int[] ans = new int[k];
        int count = 0;
        while (!pq.isEmpty()) {
            if (count == k) break;
            ans[count++] = pq.remove().idx;
        }
        return ans;
    }
 }