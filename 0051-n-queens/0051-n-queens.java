class Solution {
    public boolean isSafe(int r,int c,String[][] board){
        int n=board.length;
        //vertical
        for(int i=0;i<n;i++){
            if(i==r) continue;
            if(board[i][c].equals("Q")) return false;
        }
        //  diagonal 1 '/'
        for(int i = r-1, j = c+1; i >=0 && j < n; i--, j++){
            if(board[i][j].equals("Q")) return false;
        }

        //Diagonal -2 '\'

        for(int i=r-1,j=c-1;i>=0&&j>=0;i--,j--){
            if(board[i][j].equals("Q")) return false;
        }

        return true;
    }
    public void f(int r, int n, String[][] board, List<List<String>> ans) {
        if (r == n) {
            List<String> res=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb=new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(board[i][j]);
                }
                res.add(sb.toString());
            }
            ans.add(res);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(r, i,board)) {
                board[r][i] = "Q";
                f(r + 1, n, board, ans);
                board[r][i] = ".";
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        String[][] board = new String[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], ".");
        f(0, n, board, ans);
        return ans;
    }
}