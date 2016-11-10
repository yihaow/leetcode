public class Solution {
    /*
 * Complete the function below.
 */

    public  int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)){
            return 0;
        }
        Set<String> bankSet = new HashSet<String>();
        Set<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        int count = 0;
        for (int i = 0; i < bank.length; i++) {
            bankSet.add(bank[i]);
        }
        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size ; i++) {
                String current = queue.poll();
                if(current.equals(end)){
                    return count;
                }
                Set<String> tempSet = findCandidates(current, bankSet);
                for(String str : tempSet){
                    if(visited.contains(str)){
                        continue;
                    }
                    queue.offer(str);
                    visited.add(str);
                }
            }
            count++;
        }
        
        return visited.contains(end) ? count : -1;
    }

    public  Set<String> findCandidates(String curr, Set<String> bankSet){
        Set<String> candidates = new HashSet<String>();
        char[] numerator = {'A', 'C', 'G', 'T'};
        StringBuilder sb = new StringBuilder(curr);
        for (int i = 0; i < curr.length(); i ++){
            for(int j = 0; j < 4; j++){
                char c = sb.charAt(i);
                sb.setCharAt(i, numerator[j]);
                if (bankSet.contains(sb.toString())){
                    candidates.add(sb.toString());
                }
                sb.setCharAt(i, c);
            }
        }
        return candidates;  
    }

}
