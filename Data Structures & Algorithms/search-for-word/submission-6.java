class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        String curr = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, visited, i, j, curr))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(
        char[][] board, String word, boolean[][] visited, int i, int j, String curr) {
        if (curr.equals(word))
            return true;
        if (curr.length() >= word.length())
            return false;
        if (curr.length() > 1 && (curr.charAt(curr.length() - 1) != word.charAt(curr.length() - 1)))
            return false;
        if (i >= board.length || i < 0)
            return false;
        if (j >= board[0].length || j < 0)
            return false;
        if (visited[i][j])
            return false;

        curr += board[i][j];
        visited[i][j] = true;
        boolean exists = dfs(board, word, visited, i + 1, j, curr)
            || dfs(board, word, visited, i - 1, j, curr)
            || dfs(board, word, visited, i, j + 1, curr)
            || dfs(board, word, visited, i, j - 1, curr);
        visited[i][j] = false;
        curr = curr.substring(0, curr.length() - 1);
        return exists;
    }
}
