/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) {
            return res;
        }
        
        Stack<TreeNode> currentLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        Stack<TreeNode> temp;
        boolean level = true;
        
        currentLevel.push(root);
        while (!currentLevel.empty()) {
            ArrayList<Integer> levelVal = new ArrayList();
            while (!currentLevel.empty()) {
                TreeNode head = currentLevel.pop();
                levelVal.add(head.val);
                if (level) {
                    if (head.left != null) {
                        nextLevel.push(head.left);
                    }
                    if (head.right != null) {
                        nextLevel.push(head.right);
                    }
                }
                else {
                    if (head.right != null) {
                        nextLevel.push(head.right);
                    }
                    if (head.left != null) {
                        nextLevel.push(head.left);
                    }
                }
            }
            res.add(levelVal);
            temp = currentLevel;
            currentLevel = nextLevel;
            nextLevel = temp;
            level = !level;
        }
        return res;
    }
}
