class Solution {
    class Edge{
        int src,dest,wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    class Info{
        int src,cost,stops;
        public Info(int s,int c,int st){
            this.src=s;
            this.cost=c;
            this.stops=st;
        }
    }
    public void createGraph(int[][]flights,ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<flights.length;i++){
            int src=flights[i][0];
            int dest=flights[i][1];
            int wt=flights[i][2];
            graph[src].add(new Edge(src,dest,wt));
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge>[] graph=new ArrayList[n];
        int dist[]=new int[n];
        for(int i=0;i<n;i++){
            if(i!=src) dist[i]=Integer.MAX_VALUE;
        }
        createGraph(flights,graph);
        Queue<Info> q=new LinkedList<>();
        q.add(new Info(src,0,0));
        while(!q.isEmpty()){
            Info curr=q.remove();
            if(curr.stops>k){
                break;
            }
            for(int i=0;i<graph[curr.src].size();i++){
                Edge e=graph[curr.src].get(i);
                int u=e.src;
                int v=e.dest;
                int wt=e.wt;
                if(curr.cost+wt<dist[v]){
                    dist[v]=curr.cost+wt;
                    q.add(new Info(v,dist[v],curr.stops+1));
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE){
            return -1;
        }else{
            return dist[dst];
        }
    }
}