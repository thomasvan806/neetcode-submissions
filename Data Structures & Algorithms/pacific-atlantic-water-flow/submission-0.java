class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] pacificReached = new boolean[heights.length][heights[0].length];
        boolean[][] atlanticReached = new boolean[heights.length][heights[0].length];

        for (int i = 0; i < heights[0].length; i ++) {
            if (!pacificReached[0][i]) dfs(heights, 0, i, -1, pacificReached, atlanticReached, true, result);
        }

        for (int i = 1; i < heights.length; i ++) {
            if (!pacificReached[i][0]) dfs(heights, i, 0, -1, pacificReached, atlanticReached, true, result);
        }

        for (int i = 0; i < heights[0].length; i ++) {
            if (!atlanticReached[heights.length - 1][i]) dfs(heights, heights.length - 1, i, -1, pacificReached, atlanticReached, false, result);
        }

        for (int i = 0; i < heights.length - 1; i ++) {
            if (!atlanticReached[i][heights[0].length - 1]) dfs(heights, i, heights[0].length - 1, -1, pacificReached, atlanticReached, false, result);
        }

        return result;
    }

    private void dfs(int[][] heights, int i, int j, int previous, boolean[][] pacificReached, boolean[][] atlanticReached, boolean pacific, List<List<Integer>> result) {
        if (i < 0 || i >= heights.length) return;
        if (j < 0 || j >= heights[0].length) return;
        if (previous > heights[i][j]) return;
        if (pacific && pacificReached[i][j]) return;
        if (!pacific && atlanticReached[i][j]) return;

        if (pacific) {
            pacificReached[i][j] = true;
        } else {
            atlanticReached[i][j] = true;
        }
        if (atlanticReached[i][j] && pacificReached[i][j]) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            list.add(j);
            result.add(list);
        }
        dfs(heights, i + 1, j, heights[i][j], pacificReached, atlanticReached, pacific, result);
        dfs(heights, i - 1, j, heights[i][j], pacificReached, atlanticReached, pacific, result);
        dfs(heights, i, j + 1, heights[i][j], pacificReached, atlanticReached, pacific, result);
        dfs(heights, i, j - 1, heights[i][j], pacificReached, atlanticReached, pacific, result);
    }
}
