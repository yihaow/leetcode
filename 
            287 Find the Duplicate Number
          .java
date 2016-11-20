public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 1;
        int end = nums.length - 1;
        int mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
    }
}
