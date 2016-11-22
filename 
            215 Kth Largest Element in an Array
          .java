public class Solution {
    public int findKthLargest(int[] nums, int k) {
       int res = quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);
       return nums[res];
    }
    private int quickSelect(int[] nums, int low, int high, int k) {
        int i = low;
        int j = high;
        int pivot = nums[high];
        while (i < j) {
            if (nums[i++] > pivot) {
                swap(nums, --i, --j);
            }
        }
        swap(nums, i, high);
        int m = i - low + 1;
        if (m == k) {
            return i;
        }
        if (m > k) {
            return quickSelect(nums, low, i - 1, k);
        }
        else {
            return quickSelect(nums, i + 1, high, k - m);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
