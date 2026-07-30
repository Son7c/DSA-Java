class Solution {
    public boolean dfs(char[][] board, String word, int r, int c, int i, boolean[][] vis) {
        if (i == word.length())
            return true;

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || word.charAt(i) != board[r][c] || vis[r][c])
            return false;

        vis[r][c] = true;

        boolean found = dfs(board, word, r, c - 1, i + 1, vis) || dfs(board, word, r, c + 1, i + 1, vis)
                || dfs(board, word, r - 1, c, i + 1, vis) || dfs(board, word, r + 1, c, i + 1, vis);

        vis[r][c] = false;
        return found;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0, vis))
                    return true;
            }
        }
        return false;
    }
}