public class Solution {
    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> res = new ArrayList();
        if (n <= 0) {
            return res;
        }
        search(res, new ArrayList<Integer>(), n);
        return res;
    }
    private void search(List<List<String>> res, List<Integer> cols, int n) {
        if (cols.size() == n) {
            res.add(convert(cols));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!safe(cols, i)) {
                continue;
            }
            cols.add(i);
            search(res, cols, n);
            cols.remove(cols.size() - 1);
        }
    }
    private boolean safe(List<Integer> cols, int i) {
        int column = cols.size();
        for (int j = 0; j < cols.size(); j++) {
            if (cols.get(j) == i) {
                return false;
            }
            if (cols.get(j) - j == i - column) {
                return false;
            }
            if (cols.get(j) + j == i + column) {
                return false;
            }
        }
        return true;
    }
    private List<String> convert(List<Integer> cols) {
        int n = cols.size();
        ArrayList<String> an = new ArrayList();
        for (int i = 0; i < n; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < n; j++) {
                line.append(cols.get(i) == j ? "Q" : ".");
            }
            an.add(line.toString());
        }
        return an;
    }
}
