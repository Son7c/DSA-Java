class Solution {
    public int islandPerimeter(int[][] grid) {
        boolean[][]vis=new boolean[grid.length][grid[0].length];
        int row=-1,col=-1;
        outer:
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    row=i;
                    col=j;
                    break outer;
                }
            }
        }
        return dfs(grid,vis,row,col);
    }

    public int checkBoundary(int[][] grid, int row, int col) {
        int dr[] = { 1, -1, 0, 0 };
        int dc[] = { 0, 0, 1, -1 };
        int count = 0;

        for (int d = 0; d < 4; d++) {
            int newRow = row + dr[d];
            int newCol = col + dc[d];
            if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) {
                count++;
            }
            if (newRow >= 0 && newRow < grid.length &&
                    newCol >= 0 && newCol < grid[0].length &&
                    grid[newRow][newCol] == 0) {

                count += 1;
            } 

            
        }
        return count;
    }

    public int dfs(int[][] grid, boolean[][] vis, int row, int col) {
        vis[row][col] = true;
        int ans = 0;

        ans += checkBoundary(grid, row, col);

        int dr[] = { 1, -1, 0, 0 };
        int dc[] = { 0, 0, 1, -1 };

        for (int d = 0; d < 4; d++) {
            int newRow = row + dr[d];
            int newCol = col + dc[d];

            if (newRow >= 0 && newRow < grid.length &&
                    newCol >= 0 && newCol < grid[0].length&&!vis[newRow][newCol]&& grid[newRow][newCol]==1) {
                ans += dfs(grid, vis, newRow, newCol);
            }
        }
        return ans;
    }
}