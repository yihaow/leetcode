public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        ArrayList<Integer> list = new ArrayList();
        helper(res, list, target, candidates, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> list, int target, int[] nums, int pos) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = pos; i < nums.length; i++) {
            if (target < nums[i]) {
                continue;
            }
            list.add(nums[i]);
            helper(res, list, target - nums[i], nums, i);
            list.remove(list.size() - 1);
        }
    }
}
