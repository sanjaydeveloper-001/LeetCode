class Solution {
    private static final class Coord {
        private int x, y;
        private Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private int getDist() {
            return x * x + y * y;
        }

        @Override
        public boolean equals(Object other) {
            if(!(other instanceof Coord coord)) return false;
            return x == coord.x && y == coord.y;
        }
        @Override
        public int hashCode() {
            return x * 31 + y;
        }
    }
    private static final int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    public int robotSim(int[] commands, int[][] obstacles) {
        int dir = 0, max = 0;
        Set<Coord> invalid = new HashSet<>(obstacles.length, 1.0f);
        for(int[] x : obstacles) invalid.add(new Coord(x[0], x[1]));
        Coord current = new Coord(0, 0);
        for(int command : commands) {
            if(command == -1) dir = dir == 3 ? 0 : dir + 1;
            else if(command == -2) dir = dir == 0 ? 3 : dir - 1;
            else {
                for(int i = 0; i < command; i++) {
                    current.x += dx[dir];
                    current.y += dy[dir];
                    if(invalid.contains(current)) {
                        current.x -= dx[dir];
                        current.y -= dy[dir];
                        break;
                    }
                }
                max = Math.max(max, current.getDist());
            }
        }
        return max;
    }
}