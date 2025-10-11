class Solution {
    Integer[][] dp;
    String s;
    String t;

    public int numDistinct(String s, String t) {
        dp = new Integer[s.length() + 1][t.length() + 1];
        this.s = s;
        this.t = t;
        return helper(s.length(), t.length());
    }

    private int helper(int n1, int n2) {
        if (n2 == 0)
            return 1;
        if (n1 < n2)
            return 0;
        if (dp[n1][n2] != null)
            return dp[n1][n2];
        
        int skip = helper(n1 - 1, n2);
        int take = 0;
        if (s.charAt(n1 - 1) == t.charAt(n2 - 1)) {
            take = helper(n1 - 1, n2 - 1);
        }
        return dp[n1][n2] = skip + take;
    }
}