public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        boolean[] wb = new boolean[n + 1];
        wb[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j,i)) && wb[j]) {
                    wb[i] = true;
                    break;
                }
            }
        }
        return wb[n];
    }
}
