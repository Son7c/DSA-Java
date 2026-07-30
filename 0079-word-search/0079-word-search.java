class Solution {
    public boolean dfs(char[][] board, String word, int r, int c, int i, int[] dr, int[] dc, boolean[][] vis) {
        if (board[r][c] == word.charAt(i)) {
            vis[r][c] = true;
        } else
            return false;
        boolean ans = false;
        if (i == word.length()-1)
            return true;
        for (int j = 0; j < 4; j++) {
            int newRow = r + dr[j], newCol = dc[j] + c;
            if (newRow < board.length && newRow >= 0 && newCol < board[0].length && newCol >= 0
                    && !vis[newRow][newCol]) {

                ans = dfs(board, word, newRow, newCol, i + 1, dr, dc, vis);
                if (ans)
                    break;
            }
        }
        vis[r][c] = false;
        return ans;
    }

    public boolean exist(char[][] board, String word) {
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, 1, -1 };
        int m = board.length, n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0, dr, dc, vis))
                    return true;
            }
        }
        return false;
    }
}