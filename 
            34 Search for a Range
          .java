public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        
        int start, end, mid;
        int[] bound = new int[2];
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            }
            else if (nums[mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            bound[0] = start;
        }
        else  if (nums[end]  == target) {
            bound[0] = end;
        }
        else {
            bound[0] = bound[1] = -1;
            return bound;
        }
        
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            }
            else if (nums[mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (nums[end] == target) {
            bound[1] = end;
        }
        else  if (nums[start]  == target) {
            bound[1] = start;
        }
        else {
            bound[0] = bound[1] = -1;
            return bound;
        }
        
        return bound;
    }
}
