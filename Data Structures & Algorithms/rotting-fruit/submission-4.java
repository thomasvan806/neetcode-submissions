class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[i].length; j ++) {
                if (grid[i][j] == 2) queue.add(new int[]{i, j});
            }
        }

        int level = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i ++) {
                int[] curr = queue.remove();

                if (isValidCell(grid, curr[0] + 1, curr[1])) {
                    grid[curr[0] + 1][curr[1]] = 2;
                    queue.add(new int[]{curr[0] + 1, curr[1]});
                }
                if (isValidCell(grid, curr[0] - 1, curr[1])) {
                    grid[curr[0] - 1][curr[1]] = 2;
                    queue.add(new int[]{curr[0] - 1, curr[1]});
                }
                if (isValidCell(grid, curr[0], curr[1] + 1)) {
                    grid[curr[0]][curr[1] + 1] = 2;
                    queue.add(new int[]{curr[0], curr[1] + 1});
                }
                if (isValidCell(grid, curr[0], curr[1] - 1)) {
                    grid[curr[0]][curr[1] - 1] = 2;
                    queue.add(new int[]{curr[0], curr[1] - 1});
                }
            }
            level ++;
        }

        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[i].length; j ++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return level == 0 ? 0 : level - 1;
    }

    private boolean isValidCell(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) return false;
        if (j < 0 || j >= grid[i].length) return false;

        return grid[i][j] == 1;
    }
}
