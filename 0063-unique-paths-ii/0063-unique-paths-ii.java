class Solution {
    public int paths(int[][] dp,int [][] arr,int r,int c) {
        int i = r;
        int j = c;
        int up;
        int left;
          if(arr[0][0] == 1)
        {
            return dp[0][0]=0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }
      
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        if(arr[i][j]!=1)
        {
         up = paths(dp,arr,i-1,j);
         left = paths(dp,arr,i,j-1);
         return dp[i][j] = up + left;
        }
        return 0;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
         int r=obstacleGrid.length;
        int c=obstacleGrid[0].length;
        int[][] dp = new int[r ][c];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = paths(dp,obstacleGrid,r-1,c-1);
        return ans;
    }
}