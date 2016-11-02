public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        if(s==null||s.length()==0||p==null||p.length()==0){
            return res;
        }
        int[] hash = new int[256];
        for(char c : p.toCharArray()){
            hash[c]++;
        }
        int left=0;
        int right=0;
        int len1 = p.length();
        int len2 = s.length();
        int count = len1;
        while(right<len2){
            if(hash[s.charAt(right)]>=1){
                count--;
            }
            hash[s.charAt(right)]--;
            right++;
            if(count==0){
                res.add(left);
            }
            if(right-left==len1&&hash[s.charAt(left++)]++ >=0){
                count++;
            }
        }
        return res;
    }
}
