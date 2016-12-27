public class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }
        int m = s.length();
        int n = t.length();
        int[][] res = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            res[i][0] = 1;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j] + res[i - 1][j - 1];
                }
                else {
                    res[i][j] = res[i - 1][j];
                }
            }
        }
        return res[m][n];
    }
}
