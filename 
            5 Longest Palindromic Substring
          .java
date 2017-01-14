public class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int len = 1;
            while (i - len / 2 >= 0 && i + len / 2 < s.length()) {
                if (s.charAt(i - len / 2) != s.charAt(i + len / 2)) {
                    break;
                }
                len += 2;
            }
            len = len - 2;
            if (len > max) {
                res = s.substring(i - len / 2, i + len / 2 + 1);
                max = len;
            }
            len = 0;
            while (i - len / 2 >= 0 && i + len / 2 + 1< s.length()) {
                if (s.charAt(i - len / 2) != s.charAt(i + len / 2 + 1)) {
                    break;
                }
                len += 2;
            }
            if (len > max) {
                res = s.substring(i - len / 2 + 1, i + len / 2 + 1);
                max = len;
            }
        }
        return res;
    }
}
