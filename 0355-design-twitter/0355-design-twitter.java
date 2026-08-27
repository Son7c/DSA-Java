class Twitter {
    class Pair implements Comparable<Pair> {
        int tweet, time;

        public Pair(int _tweet, int _time) {
            tweet = _tweet;
            time = _time;
        }

        public int compareTo(Pair p2) {
            return p2.time - this.time;
        }

    }

    HashMap<Integer, List<Pair>> tweets;
    HashMap<Integer, HashSet<Integer>> followers;
    int time;

    public Twitter() {
        tweets = new HashMap<>();
        followers = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if(!tweets.containsKey(userId)){
            tweets.put(userId,new ArrayList<>());
        }
        tweets.get(userId).add(new Pair(tweetId,time));
        time++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list=new ArrayList<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i:tweets.keySet()){
            if(i==userId||(followers.containsKey(userId)&&followers.get(userId).contains(i))){
                for(Pair p:tweets.get(i)){
                    pq.add(p);
                }
            }
        }
        while(!pq.isEmpty()&&list.size()!=10){
            list.add(pq.poll().tweet);
        }
        return list;
    }

    public void follow(int followerId, int followeeId) {
        if (!followers.containsKey(followerId)) {
            followers.put(followerId, new HashSet<>());
        }
        followers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId||!followers.containsKey(followerId)) return;
        followers.get(followerId).remove(followeeId);
        if (followers.get(followerId).size() == 0)
            followers.remove(followerId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */