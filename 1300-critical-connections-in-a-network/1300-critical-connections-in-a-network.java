class Solution {
    class Edge {
        int src, dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public void dfs(ArrayList<Edge>[] graph, int curr, int par, boolean[] vis, int dt[], int low[], int time,
            List<List<Integer>> ans) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            if (neigh == par) {
                continue;
            }
            if (!vis[neigh]) {
                dfs(graph, neigh, curr, vis, dt, low, time, ans);
                low[curr] = Math.min(low[curr], low[neigh]);
                if (dt[curr] < low[neigh]) {
                    List<Integer> lt = new ArrayList<>();
                    lt.add(curr);
                    lt.add(neigh);
                    ans.add(lt);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        ArrayList<Edge>[] graph = new ArrayList[n];
        boolean[] vis = new boolean[n];
        int dt[] = new int[n];
        int low[] = new int[n];
        int time = 0;

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> list : connections) {
            int u = list.get(0);
            int v = list.get(1);
            graph[u].add(new Edge(u, v));
            graph[v].add(new Edge(v, u));
        }

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, vis, dt, low, time, ans);
            }
        }
        return ans;
    }
}