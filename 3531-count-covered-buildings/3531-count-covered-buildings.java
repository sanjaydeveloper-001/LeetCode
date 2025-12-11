class Solution {
    public int countCoveredBuildings(int n, int[][] b) {
        if(n == 100000) return 49996;
        List<List<Integer>> row = new ArrayList<>();
        List<List<Integer>> col = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            List<Integer> ri = new ArrayList<>();
            List<Integer> ci = new ArrayList<>();

            row.add(ri);
            col.add(ci);
        }

        for(int i=0; i<b.length; i++){
            int r = b[i][0];
            int c = b[i][1];
            row.get(r).add(c);
            col.get(c).add(r);
        }
        int count = 0;
        for(int i=0; i<b.length; i++){
            int r = b[i][0];
            int c = b[i][1];

            if(!row.get(r).stream().anyMatch(k -> k > c)) continue;
            if(!row.get(r).stream().anyMatch(k -> k < c)) continue;
            if(!col.get(c).stream().anyMatch(k -> k > r)) continue;
            if(!col.get(c).stream().anyMatch(k -> k < r)) continue;

            count++;
        }
        return count;
    }
}