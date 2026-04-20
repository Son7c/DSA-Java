class Solution {
    public int f(int row,int col,int[][]grid,int[][]dp){
        if(row<0 || col<0) return (int)1e9;
        if(row==0&&col==0) return grid[0][0];
        if(dp[row][col]!=-1) return dp[row][col];
        int up=grid[row][col]+f(row-1,col,grid,dp);
        int left=grid[row][col]+f(row,col-1,grid,dp);
        return dp[row][col]=Math.min(left,up);
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[]prev=new int[n];
        Arrays.fill(prev,0);
        for(int row=0;row<m;row++){
            int[]curr=new int[n];
            for(int col=0;col<n;col++){
                if(row==0&&col==0) curr[0]=grid[0][0];
                else{
                    int up=(int)1e9,left=(int) 1e9;
                    if(row>0) up=grid[row][col]+prev[col];
                    if(col>0) left=grid[row][col]+curr[col-1];
                    curr[col]=Math.min(left,up);
                }
            }
            prev=curr;
        }
        return prev[n-1];
    }
}