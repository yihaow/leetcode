public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        PriorityQueue<Map.Entry<Integer, Integer>> sort = new PriorityQueue<Map.Entry<Integer, Integer>>(new Comparator<Map
            .Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });
        for (int num : nums) {
            if (!freq.containsKey(num)) {
                freq.put(num, 1);
            }
            else {
                freq.put(num, freq.get(num) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> key : freq.entrySet()) {
            sort.offer(key);
        }
        List<Integer> res = new ArrayList();
        while (res.size() < k) {
            Map.Entry<Integer, Integer> currKey = sort.poll();
            res.add(currKey.getKey());
        }
        return res;
    }    
}
