public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max = 0;
        int i = 0;
        while(i < n && i <= max) {
            max = Math.max(nums[i] + i, max);
            if (max >= n - 1) {
                return true;
            }
            i++;
        }
        return false;
    }
}
