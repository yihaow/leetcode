public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int num = nums[i];
                if (num != i + 1 && nums[num - 1] != num) {
                    nums[i] = nums[num - 1];
                    nums[num - 1] = num;
                }
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                res.add(nums[j]);
            }
        }
        return res;
    }
}
