class Solution {
    public int dfsUtil(int[][]grid,int row,int col,int dr[],int dc[],boolean[][]vis){
        vis[row][col]=true;
        int area=1;
        for(int d=0;d<4;d++){
            int newRow=row+dr[d];
            int newCol=col+dc[d];
            if(newRow>-1&&newRow<grid.length&&newCol>-1&&newCol<grid[0].length&&grid[newRow][newCol]==1&&!vis[newRow][newCol]){
                area+=dfsUtil(grid,newRow,newCol,dr,dc,vis);
            }
        }
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea=0;
        int m=grid.length;
        int n=grid[0].length;
        boolean[][]vis=new boolean[m][n];
        int dr[]={0,0,1,-1};
        int dc[]={1,-1,0,0};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]&&grid[i][j]==1){
                    int area=dfsUtil(grid,i,j,dr,dc,vis);
                    maxArea=Math.max(area,maxArea);
                }
            }
        }
        return maxArea;
    }
}