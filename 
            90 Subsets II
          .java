public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList();
        subsets(res, list, nums, 0);
        return res;
    }
    private void subsets(List<List<Integer>> res, List<Integer> list, int[] nums, int i) {
        if (!res.contains(list)) {
               res.add(new ArrayList<Integer>(list));
            } 
        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            subsets(res, list, nums, j + 1);
            list.remove(list.size() - 1);
        }
    }
}
