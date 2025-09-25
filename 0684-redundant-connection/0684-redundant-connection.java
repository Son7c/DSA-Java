class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int V = edges.length;
        DSU dsu = new DSU(V);
        for (int[] e : edges) {
            if (dsu.find(e[0]) == dsu.find(e[1])) {
                return new int[] { e[0], e[1] };
            } else {
                dsu.union(e[0], e[1]);
            }
        }
        return new int[] { -1, -1 };
    }

    class DSU {
        int[] par;
        int[] rank;

        public DSU(int n) {
            par = new int[n+1];
            rank = new int[n+1];
            for (int i = 1; i <=n; i++) {
                par[i] = i;
            }
        }

        public int find(int i) {
            if (par[i] == i)
                return i;
            return par[i]=find(par[i]);
        }

        public void union(int x, int y) {
            int s1 = find(x);
            int s2 = find(y);
            if (rank[s1] > rank[s2]) {
                par[s2] = s1;
            } else if (rank[s2] > rank[s1]) {
                par[s1] = s2;
            } else {
                par[s2] = s1;
                rank[s2]++;
            }
        }
    }
}
