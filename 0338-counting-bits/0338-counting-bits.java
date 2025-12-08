// Leetcode Best Recursive solution
class Solution {

    private void populate(int[] ans, int i, int val){
        if(i >= ans.length) return;
        ans[i] = val;
        populate(ans, i * 2, val);
        populate(ans, i * 2 + 1, val + 1);
    }

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        populate(ans, 1, 1);

        return ans;  
    }
}