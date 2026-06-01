class Solution {
    class Pair{
        int row,col;
        public Pair(int r,int c){
            this.row=r;
            this.col=c;
        }
    }
    public void set(int[][] matrix,int r,int c){
        for(int i=0;i<matrix.length;i++){
            matrix[i][c]=0;
        }
        for(int j=0;j<matrix[0].length;j++){
            matrix[r][j]=0;
        }
    }
    public void setZeroes(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        List<Pair> list=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    list.add(new Pair(i,j));
                }
            }
        }
        for(int i=0;i<list.size();i++){
            Pair p=list.get(i);
            set(matrix,p.row,p.col);
        }
    }
}