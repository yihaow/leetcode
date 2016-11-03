public class Solution {
    public boolean canPartition(int[] nums) {
        int numSum = 0;
        for(int i = 0; i<nums.length; i++){
            numSum += nums[i];
        }
        if(numSum%2==1){
            return false;
        }
        int sum = numSum/2;
        boolean[] b = new boolean[sum+1];
        b[0] = true;
        for(int i = 0;i < nums.length; i++){
            for(int j = sum;j>=nums[i];j--){
                b[j]=b[j]||b[j-nums[i]];
            }
        }
        return b[sum];
    }
}
