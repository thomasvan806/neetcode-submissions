class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    int[] arr = new int[] {i, j};
                    queue.add(arr);
                    visited.add(Arrays.toString(arr));
                }
            }
        }

        int dist = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                int[] curr = queue.remove();
                visited.add(Arrays.toString(curr));

                grid[curr[0]][curr[1]] = dist;
                if (isValidCell(curr[0], curr[1] + 1, grid, visited)) {
                    int[] arr = new int[] {curr[0], curr[1] + 1};
                    queue.add(arr);
                    visited.add(Arrays.toString(arr));
                }
                if (isValidCell(curr[0], curr[1] - 1, grid, visited)) {
                    int[] arr = new int[] {curr[0], curr[1] - 1};
                    queue.add(arr);
                    visited.add(Arrays.toString(arr));
                }
                if (isValidCell(curr[0] + 1, curr[1], grid, visited)) {
                    int[] arr = new int[] {curr[0] + 1, curr[1]};
                    queue.add(arr);
                    visited.add(Arrays.toString(arr));
                }
                if (isValidCell(curr[0] - 1, curr[1], grid, visited)) {
                    int[] arr = new int[] {curr[0] - 1, curr[1]};
                    queue.add(arr);
                    visited.add(Arrays.toString(arr));
                }
            }
            dist++;
        }
    }

    private boolean isValidCell(int i, int j, int[][] grid, Set<String> visited) {
        if (i < 0 || i >= grid.length)
            return false;
        if (j < 0 || j >= grid[i].length)
            return false;
        if (visited.contains(Arrays.toString(new int[] {i, j})))
            return false;

        return grid[i][j] == Integer.MAX_VALUE;
    }
}
