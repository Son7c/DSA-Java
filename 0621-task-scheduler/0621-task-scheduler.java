class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            freq[tasks[i] - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0)
                pq.add(freq[i]);
        }
        int time=0;
        while (!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n + 1; i++) {
                if (!pq.isEmpty()) {
                    int f = pq.poll();
                    f--;
                    list.add(f);
                }
            }
            for (int f : list) {
                if (f > 0)
                    pq.add(f);
            }
            if(pq.isEmpty()){
                time+=list.size();
            }else time+=n+1;
        }
        return time;
    }
}