/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[][] memo = new List[n + 1][n + 1];
        return build(1, n, memo);
    }

    private List<TreeNode> build(int start, int end, List<TreeNode>[][] memo) {
        List<TreeNode> trees = new ArrayList<>();
        
        if (start > end) {
            trees.add(null);
            return trees;
        }

        if (memo[start][end] != null) {
            return memo[start][end];
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = build(start, i - 1, memo);
            List<TreeNode> right = build(i + 1, end, memo);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode node = new TreeNode(i, l, r);
                    trees.add(node);
                }
            }
        }
        return memo[start][end] = trees;
    }

    // n = 3 -> start 1 end 3
    // root = 1 -> left = start - 0 ; right = 2 - 3;

    // n = 4
    // root 2 -> left = 1 ; right = 3,4
}