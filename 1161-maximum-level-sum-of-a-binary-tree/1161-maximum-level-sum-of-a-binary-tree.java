class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 1;
        int bestLevel = 1;
        int maxSum = root.val;

        while (!q.isEmpty()) {
            int n = q.size();
            int sum = 0;

            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            if (sum > maxSum) {
                maxSum = sum;
                bestLevel = level;
            }

            level++;
        }

        return bestLevel;
    }
}
