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



//iterative way
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        //iterative

        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()){  //print  left  right   - print  right left 
            //pop current and add to ans
            TreeNode curr = st.pop();
            res.add(curr.val);

            //push right
            if (curr.right != null)
                st.push(curr.right);


            //push left
             if (curr.left != null)
                st.push(curr.left);
        }

        return res;
    }
}

// //recursive way
// class Solution {

//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         preorderHelper(root, ans);
//         return ans;
//     }

//     public void preorderHelper( TreeNode root,List<Integer> ans){
//         if (root == null) return;
//         ans.add(root.val);
//         preorderHelper(root.left, ans);
//         preorderHelper(root.right, ans);
//     }
// }