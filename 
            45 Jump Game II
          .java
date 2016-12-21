public class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int maxLoc = 0;
        int count = 0;
        int last = 0;
        while (maxLoc < nums.length - 1) {
            int max = 0;
            for (int i = last ;i <= maxLoc; i++) {
                max = Math.max(i + nums[i], max);
            }
            count++;
            last = maxLoc;
            maxLoc = max;
        }
        return count;
    }
}
