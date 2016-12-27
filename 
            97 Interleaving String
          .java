public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        boolean[][] res = new boolean[m + 1][n + 1];
        res[0][0] = true;
        for (int i = 1; i < m + 1; i++) {
            res[i][0] = (s3.charAt(i - 1) == s1.charAt(i - 1)) && res[i - 1][0];
        }
        for (int j = 1; j < n + 1; j++) {
            res[0][j] = (s3.charAt(j - 1) == s2.charAt(j - 1)) && res[0][j - 1];
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                res[i][j] = (res[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1)) || 
                    (res[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));
            }
        }
        return res[m][n];
    }
}
