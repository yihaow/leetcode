public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] store = new int[target+1];
        store[0]=1;
        
        int i = 0;
        int j = 0;
        while(j<target+1){
            while(i<nums.length){
                if(j+nums[i]<target+1){
                    store[j+nums[i]] += store[j];
                }
                i++;
            }
            i = 0;
            j++;
        }
        return store[target];
    }
}
