public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        ArrayList<Integer> list = new ArrayList();
        Arrays.sort(candidates);
        helper(res, list, target, 0, candidates);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> list, int target, int pos, int[] nums) {
        if (target == 0) {
            if (!res.contains(list)) {
                res.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for(int i = pos; i < nums.length; i++) {
            if (target < nums[i]) {
                continue;
            }
            list.add(nums[i]);
            helper(res, list, target - nums[i], i + 1, nums);
            list.remove(list.size() - 1);
        }
    }
}
