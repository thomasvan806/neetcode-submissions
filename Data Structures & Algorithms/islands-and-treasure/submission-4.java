class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        // Set<String> visited = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    int[] arr = new int[] {i, j};
                    queue.add(arr);
                }
            }
        }

        int dist = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                int[] curr = queue.remove();

                // grid[curr[0]][curr[1]] = dist;
                if (isValidCell(curr[0] - 1, curr[1], grid)) {
                    int[] arr = new int[] {curr[0] - 1, curr[1]};
                    queue.add(arr);
                    grid[curr[0] - 1][curr[1]] = dist + 1;
                }
                if (isValidCell(curr[0], curr[1] - 1, grid)) {
                    int[] arr = new int[] {curr[0], curr[1] - 1};
                    queue.add(arr);
                    grid[curr[0]][curr[1] - 1] = dist + 1;
                }
                if (isValidCell(curr[0] + 1, curr[1], grid)) {
                    int[] arr = new int[] {curr[0] + 1, curr[1]};
                    queue.add(arr);
                    grid[curr[0] + 1][curr[1]] = dist + 1;
                }
                if (isValidCell(curr[0], curr[1] + 1, grid)) {
                    int[] arr = new int[] {curr[0], curr[1] + 1};
                    queue.add(arr);
                    grid[curr[0]][curr[1] + 1] = dist + 1;
                }
            }
            dist++;
        }
    }

    private boolean isValidCell(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length)
            return false;
        if (j < 0 || j >= grid[i].length)
            return false;

        return grid[i][j] == Integer.MAX_VALUE;
    }
}
