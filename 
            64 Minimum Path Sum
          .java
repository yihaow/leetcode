public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int[][] sums = new int[grid.length][grid[0].length];
        sums[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            sums[0][i] = sums[0][i - 1] + grid[0][i];
        } 
        for (int j = 1; j < grid.length; j++) {
            sums[j][0] = sums[j - 1][0] + grid[j][0];
        }
        for (int x = 1; x < grid.length; x++) {
            for (int y = 1; y < grid[0].length; y++) {
                sums[x][y] = Math.min(sums[x - 1][y], sums[x][y - 1]) + grid[x][y];
            }
        }
        return sums[grid.length - 1][grid[0].length - 1];
    }
}
