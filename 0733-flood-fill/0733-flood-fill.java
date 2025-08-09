class Solution {
    class Pair{
        int row,col,color;
        public Pair(int r,int c,int co){
            this.row=r;
            this.col=c;
            this.color=co;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int origin=image[sr][sc];
        int[] dr={0,0,1,-1};
        int dc[]={1,-1,0,0};
        int m=image.length;
        int n=image[0].length;
        Queue<Pair> q=new LinkedList<>();
        boolean[][]vis=new boolean[m][n];
        q.add(new Pair(sr,sc,color));
        while(!q.isEmpty()){
            Pair curr=q.remove();
            if(!vis[curr.row][curr.col]){
                vis[curr.row][curr.col]=true;
                image[curr.row][curr.col]=color;
                int newRow,newCol;
                for(int d=0;d<4;d++){
                    newRow=curr.row+dr[d];
                    newCol=curr.col+dc[d];
                    if(newRow>-1 && newRow<m &&newCol>-1&&newCol<n &&!vis[newRow][newCol]&&image[newRow][newCol]==origin){
                        q.add(new Pair(newRow,newCol,color));
                    }
                }
            }
        }
        return image;
    }
}