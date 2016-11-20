public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int redP = 0;
        int blueP = nums.length - 1;
        int i = 0;
        while (i <= blueP) {
            if (nums[i] == 0) {
                swap(nums, i, redP);
                redP++;
                i++;
            }
            else if (nums[i] == 1) {
                i++;
            }
            else {
                swap(nums, i, blueP);
                blueP--;
            }
        }
    }
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
