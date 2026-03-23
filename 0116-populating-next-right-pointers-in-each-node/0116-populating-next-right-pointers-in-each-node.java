class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            int n = que.size();
            Node prev = null;
            while(n-- > 0){
                Node temp = que.poll();

                if(prev != null) {
                    prev.next = temp;
                }
                prev = temp;

                if(temp.left != null) que.add(temp.left);
                if(temp.right != null) que.add(temp.right);                
            }
        }
        return root;
    }
}