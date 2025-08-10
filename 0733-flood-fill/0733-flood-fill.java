class Solution {
    class Pair{
        int row,col;
        public Pair(int r,int c){
            this.row=r;
            this.col=c;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Pair> q=new LinkedList<>();
        int originalCol=image[sr][sc];
        int[]dr={0,0,1,-1};
        int[]dc={1,-1,0,0};
        int m=image.length;
        int n=image[0].length;
        q.add(new Pair(sr,sc));
        boolean[][]vis=new boolean[m][n];
        int newRow,newCol;
        while(!q.isEmpty()){
            Pair curr=q.remove();
            if(!vis[curr.row][curr.col]){
                image[curr.row][curr.col]=color;
                vis[curr.row][curr.col]=true;
                for(int d=0;d<4;d++){
                    newRow=curr.row+dr[d];
                    newCol=curr.col+dc[d];
                    if(newRow>-1 &&newRow<m &&newCol>-1&&newCol<n &&!vis[newRow][newCol]&&image[newRow][newCol]==originalCol){
                        q.add(new Pair(newRow,newCol));
                    }
                }
            }
        }
        return image;
    }
}