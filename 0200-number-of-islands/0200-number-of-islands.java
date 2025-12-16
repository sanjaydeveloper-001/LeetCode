class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int count = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == '1'){ 
                    funt(grid, i, j);
                    count++;
                }
            }
        }
        return count;

    }


    public static void funt(char [][]grid, int i, int j){
        int r = grid.length;
        int c = grid[0].length;

        if( i < 0 || j < 0 || i >= r || j >= c || grid[i][j] == '0') return;
        grid[i][j] = '0';
        
        funt(grid, i+1, j); //Down
        funt(grid, i, j+1); //Right
        funt(grid, i-1, j); //Up
        funt(grid, i, j-1); //Left

    }
}