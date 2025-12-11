class Solution {
    public int countCoveredBuildings(int n, int[][] b) {
        int maxrow[] = new int[n+1];
        int minrow[] = new int[n+1];
        int maxcol[] = new int[n+1];
        int mincol[] = new int[n+1];

        Arrays.fill(minrow, n + 1);
        Arrays.fill(mincol, n + 1);

        for(int i=0; i<b.length; i++){
            int r = b[i][0];
            int c = b[i][1];
            maxrow[c] = Math.max(maxrow[c], r);
            minrow[c] = Math.min(minrow[c], r);
            maxcol[r] = Math.max(maxcol[r], c);
            mincol[r] = Math.min(mincol[r], c);
        }
        int count = 0;
        for(int i=0; i<b.length; i++){
            int r = b[i][0];
            int c = b[i][1];
            if( r < maxrow[c] && r > minrow[c] && c < maxcol[r] && c > mincol[r] )
                count++;
        }
        return count;
    }
}