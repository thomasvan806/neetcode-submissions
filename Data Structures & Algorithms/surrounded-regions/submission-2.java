class Solution {
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board[0].length; i ++) {
            if (!visited[0][i] && board[0][i] == 'O') dfs(board, 0, i, visited);
        }

        for (int i = 1; i < board.length - 1; i ++) {
            if (!visited[i][0] && board[i][0] == 'O') dfs(board, i, 0, visited);
        }

        for (int i = 1; i < board.length - 1; i ++) {
            if (!visited[i][board[0].length - 1] && board[i][board[0].length - 1] == 'O') dfs(board, i, board[0].length - 1, visited);
        }

        for (int i = 0; i < board[0].length; i ++) {
            if (!visited[board.length - 1][i] && board[board.length - 1][i] == 'O') dfs(board, board.length - 1, i, visited);
        }

        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j ++) {
                if (!visited[i][j] && board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= board.length) return;
        if (j < 0 || j >= board[i].length) return;
        if (visited[i][j]) return;
        if (board[i][j] == 'X') return;

        visited[i][j] = true;
        dfs(board, i + 1, j, visited);
        dfs(board, i - 1, j, visited);
        dfs(board, i, j + 1, visited);
        dfs(board, i, j - 1, visited);
    }
}
