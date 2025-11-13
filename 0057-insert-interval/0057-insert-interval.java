class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int n = intervals.length, i = 0;

        // Step 1: Add the chill guys (no overlap)
        while (i < n && newInterval[0] > intervals[i][1])
            res.add(intervals[i++]);

        // Step 2: Merge with whoever crashes the party
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Step 3: Add the final merged interval
        res.add(newInterval);

        // Step 4: Add the latecomers
        while (i < n)
            res.add(intervals[i++]);

        return res.toArray(new int[res.size()][]);
    }
}