class Solution {

    private int[] rank;
    private int[] root;
    private int row;
    private int col;
    private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    private int leftWaterId;
    private int rightWaterId;

    public int latestDayToCross(int row, int col, int[][] cells) { //DSU on water cells solution 
        this.row = row;
        this.col = col;
        rank = new int[(row * col) + 2]; // +1 is left side root which every water cell on left side will be connected to, +2 is right side 
        root = new int[(row * col) + 2]; // +1 is left side root which every water cell on left side will be connected to, +2 is right side
        leftWaterId = (row * col); // read above
        rightWaterId = (row * col) + 1; // read above
        root[leftWaterId] = leftWaterId; // read above
        root[rightWaterId] = rightWaterId; // read above
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                root[toId(i, j)] = toId(i, j);
            }
        }
        boolean[][] water = new boolean[row][col];

        for(int i=0; i<cells.length; i++) {
            int x = cells[i][0]-1;
            int y = cells[i][1]-1;

            water[x][y] = true;

            if(y == 0) {
                union(toId(x, y), leftWaterId);
            }
            else if(y == col-1) {
                union(toId(x, y), rightWaterId);
            }
            
            for(int[] dir: DIRECTIONS) {
                int newx = x + dir[0];
                int newy = y + dir[1];
                if(valid(newx, newy) && water[newx][newy]) {
                    union(toId(x, y), toId(newx, newy));
                }
            }
            if(find(leftWaterId) == find(rightWaterId)) {
                return i;
            }
        }

        return -1;
    }

    private int toId(int x, int y) {
        return x * col + y;
    }

    private void union(int id1, int id2) {
        int root1 = find(id1);
        int root2 = find(id2);

        if(rank[root1] == rank[root2]) {
            rank[root1]++;
            root[root2] = root[root1];
        }
        else if(rank[root1] > rank[root2]) {
            root[root2] = root[root1];
        }
        else {
            root[root1] = root[root2];
        }
    }

    private int find(int id) {
        while(root[id] != id) {
            root[id] = root[root[id]];
            id = root[id];
        }
        return id;
    }

    private boolean valid(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }











    // public int latestDayToCross(int row, int col, int[][] cells) { //binsearch and bfs exploring for checking the mid value solution
    //     int left = 0;
    //     int right = cells.length;

    //     while(left <= right) {
    //         int mid = left + ((right - left) / 2);
    //         if(check(row, col, cells, mid)) {
    //             left = mid + 1;
    //         }
    //         else {
    //             right = mid - 1;
    //         }
    //     }

    //     return right;
    // }

    // private boolean check(int row, int col, int[][] cells, int day) {
    //     boolean[][] matrix = prepare(row, col, cells, day);
    //     for(int i=0; i<col; i++) {
    //         if(!matrix[0][i] && dfs(matrix, i, row, col)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // private boolean[][] prepare(int row, int col, int[][] cells, int day) {
    //     boolean[][] matrix = new boolean[row][col];
    //     for(int i=0; i<day; i++) {
    //         matrix[cells[i][0]-1][cells[i][1]-1] = true;
    //     }
    //     return matrix;
    // }

    // private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // private boolean valid(int x, int y, int row, int col) {
    //     return x >= 0 && y >= 0 && x < row && y < col;
    // }

    // private boolean dfs(boolean[][] matrix, int start, int row, int col) {
    //     Deque<int[]> stack = new ArrayDeque<>();
    //     boolean[][] seen = new boolean[row][col];
    //     stack.offerLast(new int[]{0, start});
    //     seen[0][start] = true;

    //     while(!stack.isEmpty()) {
    //         int[] curr = stack.pollLast();
    //         if(curr[0] == row - 1) {
    //             return true;
    //         }
    //         for(int[] dir: DIRECTIONS) {
    //             int newx = curr[0] + dir[0];
    //             int newy = curr[1] + dir[1];
    //             if(valid(newx, newy, row, col) && !seen[newx][newy] && !matrix[newx][newy]) {
    //                 seen[newx][newy] = true;
    //                 stack.offerLast(new int[] {newx, newy});
    //             }
    //         }
    //     }

    //     return false;
    // }

}