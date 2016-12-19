public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] pathSum = new int[m][n];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        pathSum[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                pathSum[i][0] = 0;
            }
            else {
                pathSum[i][0] = pathSum[i - 1][0];
            }
        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                pathSum[0][j] = 0;
            }
            else {
                pathSum[0][j] = pathSum[0][j - 1];
            }
        }
        for (int x = 1; x < m; x++) {
            for (int y = 1; y < n; y++) {
                if (obstacleGrid[x][y] == 1) {
                    pathSum[x][y] = 0;
                }
                else {
                    pathSum[x][y] = pathSum[x -1][y] + pathSum[x][y - 1];
                }
            }
        }
        return pathSum[m - 1][n - 1];
    }
}
