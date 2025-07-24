class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1, right = cells.length, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canWalk(cells, row, col, mid)) {
                ans = mid; 
                left = mid + 1; 
            } else right = mid - 1;
        }
        return ans;
    }
    int[] DIR = new int[]{0, 1, 0, -1, 0};
    boolean canWalk(int[][] cells, int row, int col, int dayAt) {
        int[][] grid = new int[row][col];
        for (int i = 0; i < dayAt; ++i) grid[cells[i][0]-1][cells[i][1]-1] = 1;
        Queue<int[]> bfs = new ArrayDeque<>();
        for (int c = 0; c < col; ++c) {
            if (grid[0][c] == 0) {
                bfs.offer(new int[]{0, c});
                grid[0][c] = 1; 
            }
        }
        while (!bfs.isEmpty()) {
            int[] curr = bfs.poll();
            int r = curr[0], c  = curr[1];
            if (r == row - 1) return true; 
            for (int i = 0; i < 4; ++i) {
                int nr = r + DIR[i], nc = c + DIR[i+1];
                if (nr < 0 || nr == row || nc < 0 || nc == col || grid[nr][nc] == 1) continue;
                grid[nr][nc] = 1;
                bfs.offer(new int[]{nr, nc});
            }
        }
        return false;
    }
}