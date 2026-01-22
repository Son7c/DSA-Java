class Solution {
    public int dfsUtil(int[][] grid,boolean[][] vis,int row,int col,int[] dr,int[] dc){
        int area=1;
        vis[row][col]=true;
        for(int i=0;i<4;i++){
            int newRow=row+dr[i];
            int newCol=col+dc[i];
            if(newRow>=0&&newRow<grid.length&&newCol>=0&&newCol<grid[0].length&&!vis[newRow][newCol]&&grid[newRow][newCol]==1){
                area+=dfsUtil(grid,vis,newRow,newCol,dr,dc);
            }
        }
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean vis[][]=new boolean[m][n];
        int area=0;
        int dr[]={0,0,1,-1};
        int dc[]={-1,1,0,0};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]&&grid[i][j]==1){
                    area=Math.max(area,dfsUtil(grid,vis,i,j,dr,dc));
                }
            }
        }
        return area;
    }
}