public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (wordList == null) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }
        
        wordList.add(beginWord);
        wordList.add(endWord);
        HashSet<String> hash = new HashSet();
        Queue<String> queue = new LinkedList<String>();
        int length = 1;
        hash.add(beginWord);
        queue.offer(beginWord);
        while(!queue.isEmpty()) {
            int size = queue.size();
            length++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord : getNextWord(word, wordList)) {
                    if (hash.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(endWord)) {
                        return length;
                    }
                    queue.offer(nextWord);
                    hash.add(nextWord);
                }
            }
        }
        return 0;
    }
    private List<String> getNextWord(String word, Set<String> wordList) {
        ArrayList<String> nextWords = new ArrayList();
        for (int i = 0; i < word.length(); i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, j);
                if (wordList.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
    private String replace(String word, int i, char j) {
        char[] chars = word.toCharArray();
        chars[i] = j;
        return new String(chars);
    }
}
