public class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int len = 0;
            while(i - len >= 0 && i + len < s.length()){
                if (s.charAt(i - len) != s.charAt(i + len)) {
                    break;
                }
                len++;
            }
            len--;
            if (len * 2 + 1 > max) {
                max = len * 2 + 1;
                res = s.substring(i - len, i + len + 1);
            }
            len = 0; 
            while(i - len - 1 >= 0 && i + len < s.length()) {
                if (s.charAt(i - len - 1) != s.charAt(i + len)) {
                    break;
                }
                len++;
            }
            len--;
            if (len * 2 + 2 > max) {
                max = len * 2 + 2;
                res = s.substring(i - len - 1, i + len + 1);
            }
        }
        return res;
    }
}
