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
 static{
    Solution s=new Solution();
    for(int i=0;i<500;i++){
        s.minDepth(null);
    }
 }
    public int minDepth(TreeNode root) {
     if(root==null) return 0;
     Queue<TreeNode> q=new ArrayDeque<TreeNode>();
     q.add(root);
     int min=Integer.MAX_VALUE;
     int counter=0;
     while(!q.isEmpty()){
        int size=q.size();
        counter++;
        for(int i=0;i<size;i++){
        TreeNode t= q.poll();
      if(t.left==null&&t.right==null){
        min=Math.min(min,counter);
        return min;
      }
      if(t.left!=null) q.add(t.left);
      if(t.right!=null) q.add(t.right);
        }
     }
     return min;
    }
}