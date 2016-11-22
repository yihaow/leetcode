public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap();
        List<Integer>[] sort = new List[nums.length + 1];
        if (nums == null || nums.length == 0) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!freq.containsKey(nums[i])) {
                freq.put(nums[i], 1);
            }
            else {
                freq.put(nums[i], freq.get(nums[i]) + 1);
            }
        }
        for (int key : freq.keySet()) {
            int frequence = freq.get(key);
            if (sort[frequence] == null) {
                sort[frequence] = new ArrayList();
            }
            sort[frequence].add(key);
        }
        ArrayList<Integer> res = new ArrayList();
        for (int j = nums.length; j >= 0 && res.size() < k; j--) {
            if (sort[j] != null) {
                res.addAll(sort[j]);
            }
        }
        return res;
    }
}
