class Solution {
    class Edge{
        int src,dest,wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    class Pair implements Comparable <Pair>{
        int n,wt;
        public Pair(int n,int wt){
            this.n=n;
            this.wt=wt;
        }
        @Override
        public int compareTo(Pair p2){
            return this.wt-p2.wt;
        }
    }
    public void createGraph(int[][]points,ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<points.length-1;i++){
            for(int j=i+1;j<points.length;j++){
                int src=i;
                int dest=j;
                int wt=Math.abs(points[i][1]-points[j][1])+Math.abs(points[i][0]-points[j][0]);
                graph[src].add(new Edge(src,dest,wt));
                graph[dest].add(new Edge(dest,src,wt));
            }
        }
    }

    public int findMst(int n,ArrayList<Edge>[] graph){
        boolean[]vis=new boolean[n];
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        pq.add(new Pair(0,0));
        int cost=0;
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!vis[curr.n]){
                vis[curr.n]=true;
                cost+=curr.wt;
                for(int i=0;i<graph[curr.n].size();i++){
                    Edge e=graph[curr.n].get(i);
                    pq.add(new Pair(e.dest,e.wt));
                }
            }
        }
        return cost;
    }
    public int minCostConnectPoints(int[][] points) {
        ArrayList<Edge>[] graph=new ArrayList[points.length];
        createGraph(points,graph);
        return findMst(points.length,graph);
    }
}