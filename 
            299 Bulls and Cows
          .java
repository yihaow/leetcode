public class Solution {
    public String getHint(String secret, String guess) {
        int[] nums = new int[10];
        int size = secret.length();
        int a = 0;
        int b = 0;
        int se, gu;
        for(int i=0;i<size;i++){
            se = secret.charAt(i)-'0';
            gu = guess.charAt(i)-'0';
            if(se==gu){
                a++;
            }
            else{
                if(nums[se]<0){
                    b++;
                }
                nums[se]++;
                if(nums[gu]>0){
                    b++;
                }
                nums[gu]--;
            }
        }
        return a+"A"+b+"B";
    }
}
