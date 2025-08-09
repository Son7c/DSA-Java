class Solution {
    public boolean searchPath(int n, ArrayList<Edge>[] graph, int src, int dest, boolean vis[]) {
        if (src == dest) {
            return true;
        }
        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!vis[e.dest] && searchPath(n, graph, e.dest, dest, vis)) {
                return true;
            }
        }
        return false;
    }

    class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] vertex : edges) {
            graph[vertex[0]].add(new Edge(vertex[0], vertex[1]));
            graph[vertex[1]].add(new Edge(vertex[1], vertex[0]));
        }

        return searchPath(n, graph, source, destination, new boolean[n]);
    }
}