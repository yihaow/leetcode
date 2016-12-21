public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] subLength = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            subLength[i] = 1;
        }
        for (int m = 0; m < nums.length; m++) {
            for (int n = 0; n < m; n++) {
                if (nums[m] > nums[n]) {
                    subLength[m] = Math.max(subLength[m], subLength[n] + 1);
                }
            }
        }
        int res = 0;
        for (int j = 0; j < nums.length; j++) {
            res = Math.max(res, subLength[j]);
        }
        return res;
    }
}
