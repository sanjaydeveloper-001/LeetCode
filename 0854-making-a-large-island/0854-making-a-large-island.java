class Solution {
    int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    public int largestIsland(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int islandId = 2;
        Map<Integer, Integer> areaMap = new HashMap<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, islandId);
                    areaMap.put(islandId, area);
                    islandId++;
                }
            }
        }

        int maxArea = areaMap.values().stream().max(Integer::compare).orElse(0);

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> neighborIslands = new HashSet<>();
                    for (int[] d : dir) {
                        int ni = i + d[0], nj = j + d[1];
                        if (ni >= 0 && nj >= 0 && ni < R && nj < C && grid[ni][nj] > 1) {
                            neighborIslands.add(grid[ni][nj]);
                        }
                    }
                    int newArea = 1; 
                    for (int id : neighborIslands) {
                        newArea += areaMap.get(id);
                    }
                    maxArea = Math.max(maxArea, newArea);
                }
            }
        }
        
        return maxArea == 0 ? R * C : maxArea;
    }
    
    private int dfs(int[][] grid, int i, int j, int id) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) return 0;
        grid[i][j] = id;
        int area = 1;
        for (int[] d : dir) {
            area += dfs(grid, i + d[0], j + d[1], id);
        }
        return area;
    }
}
