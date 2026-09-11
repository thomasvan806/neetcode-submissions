class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        int index = (left + right) / 2;
        int row = index / matrix[0].length;
        int col = index % matrix[0].length;
        while (matrix[row][col] != target && left < right) {
            if (matrix[row][col] < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
            index = (left + right) / 2;
            row = index / matrix[0].length;
            col = index % matrix[0].length;
        }

        return matrix[row][col] == target;
    }
}
