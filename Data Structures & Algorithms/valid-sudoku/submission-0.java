class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[board.length][board.length];
        boolean[][] cols = new boolean[board.length][board.length];
        boolean[][] grids = new boolean[board.length][board.length];

        for (int row = 0; row < board.length; row ++) {
            for (int col = 0; col < board[row].length; col ++) {
                if (board[row][col] != '.') {
                    int val = ((int) board[row][col]) - 48;
                    if (rows[row][val - 1]) {
                        return false;
                    } else {
                        rows[row][val - 1] = true;
                    }
                    if (cols[col][val - 1]) {
                        return false;
                    } else {
                        cols[col][val - 1] = true;
                    }
                    if (grids[getGrid(row, col) - 1][val - 1]) {
                        return false;
                    } else {
                        grids[getGrid(row, col) - 1][val - 1] = true;
                    }
                }
            }
        }
        return true;
    }

    private int getGrid(int row, int col) {
        if (row < 3) {
            if (col < 3) {
                return 1;
            } else if (col < 6) {
                return 2;
            } else {
                return 3;
            }
        } else if (row < 6) {
            if (col < 3) {
                return 4;
            } else if (col < 6) {
                return 5;
            } else {
                return 6;
            }
        } else {
            if (col < 3) {
                return 7;
            } else if (col < 6) {
                return 8;
            } else {
                return 9;
            }
        }
    }
}
