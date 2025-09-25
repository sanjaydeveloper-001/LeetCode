class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[n][m] = true;

        for(int j = m - 1; j >= 0; j--){
            if(p.charAt(j) == '*') dp[n][j] = dp[n][j + 1];
        }

        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                if(p.charAt(j) == '*'){
                    boolean noPick = dp[i][j + 1];
                    boolean pick = dp[i + 1][j];
                    dp[i][j] = pick || noPick;
                }
                else{
                    if(p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)){
                        dp[i][j] = dp[i + 1][j + 1];
                    }
                }
            }
        }
        return dp[0][0];
    }
}