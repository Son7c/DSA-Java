class Solution {
    public boolean check(char[][]board,int row,int col,char ch){
        for(int i=0;i<9;i++){
            if(board[i][col]==ch&&i!=row)return false;
        }
        for(int i=0;i<9;i++){
            if(board[row][i]==ch&&i!=col) return false;
        }
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(board[i][j]==ch&&(i!=row&&j!=col)) return false;
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char ch=board[i][j];
                if(ch!='.'){
                    boolean isSafe=check(board,i,j,ch);
                if(!isSafe) return false;
                }
                
            }
        }
        return true;
    }
}