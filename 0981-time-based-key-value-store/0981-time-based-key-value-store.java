class Pair {
    int ts;
    String val;

    public Pair(int t, String s) {
        this.ts = t;
        this.val = s;
    }
}

class TimeMap {
    HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        String res = "";
        if (!map.containsKey(key))
            return res;
        List<Pair> list = map.get(key);
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).ts == timestamp) {
                return list.get(mid).val;
            }
            if (list.get(mid).ts < timestamp) {
                res = list.get(mid).val;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */