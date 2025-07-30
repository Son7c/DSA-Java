class cycleInUnDirectedGraphDfs {
    static class Edge{
        int src;
        int dest;
        
        public Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public boolean detectCycle(ArrayList<Edge>[]graph){
        boolean[] vis=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(detectCycleUtil(graph,vis,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean detectCycleUtil(ArrayList<Edge>[]graph,boolean[] vis,int curr,int par){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            
            if(!vis[e.dest]){
                if(detectCycleUtil(graph,vis,e.dest,curr)){
                    return true;
                }
            }
            else if(vis[e.dest]&& e.dest!=par){
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<Edge>[]graph=new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] vertex:edges){
            graph[vertex[0]].add(new Edge(vertex[0],vertex[1]));
            graph[vertex[1]].add(new Edge(vertex[1],vertex[0]));
        }
        
        return detectCycle(graph);
    }
}