class Solution {
    class Pair{
        int row,col,tm;
        public Pair(int r,int c,int t){
            this.row=r;
            this.col=c;
            this.tm=t;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        int freshCount=0;
        boolean [][] vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=true;
                }
                if(grid[i][j]==1){
                    freshCount++;
                }
            }
        }
        int tm=0,rotCount=0;
        int[]dr={0,0,1,-1};
        int[]dc={1,-1,0,0};
        while(!q.isEmpty()){
            Pair curr=q.remove();
            tm=Math.max(tm,curr.tm);
            for(int d=0;d<4;d++){
                int newRow=curr.row+dr[d];
                int newCol=curr.col+dc[d];
                if(newRow>-1 && newRow<m && newCol>-1 && newCol<n&&!vis[newRow][newCol]&&grid[newRow][newCol]==1){
                    q.add(new Pair(newRow,newCol,curr.tm+1));
                    vis[newRow][newCol]=true;
                    rotCount++;
                }
            }
            
        }
        return rotCount==freshCount?tm:-1;
    }
}