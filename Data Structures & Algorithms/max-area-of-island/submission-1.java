class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[i].length; j ++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, size(i, j, grid));
                }
            }
        }

        return res;
    }

    private int size(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length) return 0;
        if (j < 0 || j >= grid[i].length) return 0;
        if (grid[i][j] == 0) return 0;

        grid[i][j] = 0;
        return 1 + size(i + 1, j, grid) + size(i - 1, j, grid) + size(i, j - 1, grid) + size(i, j + 1, grid);
    }
}
