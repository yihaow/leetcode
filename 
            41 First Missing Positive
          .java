public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (num > 0 && num <= nums.length && num != nums[num - 1]) {
                int temp = nums[num - 1];
                nums[num - 1] = num;
                nums[i] = temp;
                num = nums[i];
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return  nums.length + 1;
    }
}
