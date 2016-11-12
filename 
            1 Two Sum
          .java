public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> twoSum = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            twoSum.put(nums[i],i);
        }

        for(int i=0; i<nums.length; i++){
            if(twoSum.containsKey(target-nums[i]) && twoSum.get(target-nums[i])!=i){
                return new int[] {i,twoSum.get(target-nums[i])};
            }
        }
        return new int[] {0};
    }
}
