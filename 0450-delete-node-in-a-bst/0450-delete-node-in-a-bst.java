class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val == key){
            if(root.left == null && root.right == null) return null;
            if(root.left != null && root.right == null) return root.left;
            if(root.left == null && root.right != null) return root.right;
            else{
                TreeNode n = root.right;
                while(n.left != null){
                    n = n.left;
                }
                root.val = n.val;
                root.right = deleteNode(root.right, n.val);
                return root;
            }
        }
        else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }

        return root;
    }
}