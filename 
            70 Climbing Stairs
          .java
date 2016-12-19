public class Solution {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] stair = new int[n + 1];
        stair[0] = 1;
        stair[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            stair[i] = stair[i - 1] + stair[i - 2];
        }
        return stair[n];
    }
}
