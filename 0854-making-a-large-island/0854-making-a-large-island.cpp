class Solution {
public:
    int largestIsland(vector<vector<int>>& grid) {
        int n = grid.size();
        vector<vector<int>> directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        unordered_map<int, int> area;
        int index = 2, max_area = 0;

        function<int(int, int, int)> dfs = [&](int r, int c, int id) {
            if (r < 0 || c < 0 || r >= n || c >= n || grid[r][c] != 1) return 0;
            grid[r][c] = id;
            int res = 1;
            for (auto& d : directions) {
                res += dfs(r + d[0], c + d[1], id);
            }
            return res;
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    area[index] = dfs(i, j, index);
                    max_area = max(max_area, area[index++]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    unordered_set<int> seen;
                    int new_area = 1;
                    for (auto& d : directions) {
                        int ni = i + d[0], nj = j + d[1];
                        if (ni >= 0 && nj >= 0 && ni < n && nj < n && grid[ni][nj] > 1) {
                            seen.insert(grid[ni][nj]);
                        }
                    }
                    for (int id : seen) new_area += area[id];
                    max_area = max(max_area, new_area);
                }
            }
        }

        return max_area;
    }
};
