class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int r = grid.length;
        int c = grid[0].length;

        int max = 0;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] == 1){
                    max = Math.max(max, maxLand(grid, i, j));
                }
            }
        }

        return max;
    }
    public int maxLand(int [][] grid, int i, int j){
            int r = grid.length;
            int c = grid[0].length; 

            if(i<0 || j<0 || i>=r || j>=c || grid[i][j]== 0){
                return 0;
            }
            grid[i][j] = 0;

            int curmax = 1;

            curmax += maxLand(grid, i+1 , j);
            curmax += maxLand(grid, i-1 , j);
            curmax += maxLand(grid, i , j+1);
            curmax += maxLand(grid, i , j-1);

            return curmax;
        }
}