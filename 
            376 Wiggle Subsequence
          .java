public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        int[] store = new int[nums.length+1];
        store[0] = 0;
        store[1] = 1;
        int j = 2;
        while(j<=nums.length&&nums[j-1]==nums[j-2]){
            store[j]=1;
            j++;
        }
        if(j<=nums.length){
            store[j]=2;
            if(nums[j-1]-nums[0]<0){
                store[j] *= -1;
            }
        }
        for(int i = j; i<nums.length;i++){
            if((nums[i]-nums[i-1])*store[i]<0){
                if((nums[i]-nums[i-1])<0){
                    store[i+1] = (store[i]+1)*(-1);
                }
                else{
                    store[i+1] = (store[i]-1)*(-1);
                }
            }
            else{
                store[i+1]=store[i];
            }
        }
        if(store[nums.length]<0){
            return store[nums.length]*(-1);
        }
        return store[nums.length];
    }
}
