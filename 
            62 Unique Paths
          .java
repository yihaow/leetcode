public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] pathSum = new int[m][n];
        for (int i = 0; i < m; i++) {
            pathSum[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            pathSum[0][j] = 1;
        }
        for (int x = 1; x < m; x++) {
            for (int y = 1; y < n; y++) {
                pathSum[x][y] = pathSum[x - 1][y] + pathSum[x][y - 1];
            }
        }
        return pathSum[m - 1][n - 1];
    }
}
