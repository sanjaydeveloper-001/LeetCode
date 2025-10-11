class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> output = new ArrayList<>();
        dfs(root, targetSum, 0, output, new ArrayList<>());
        return output;
    }

    private void dfs(TreeNode root, int targetSum, int curSum,
        List<List<Integer>> output, List<Integer> currentPath) {
        if (root == null) return;
        curSum += root.val;
        currentPath.add(root.val);
        if (root.left == null && root.right == null && curSum == targetSum) {
            output.add(new ArrayList<>(currentPath));
        }
        dfs(root.left, targetSum, curSum, output, currentPath);
        dfs(root.right, targetSum, curSum, output, currentPath);
        currentPath.remove(currentPath.size() - 1);
    }
}