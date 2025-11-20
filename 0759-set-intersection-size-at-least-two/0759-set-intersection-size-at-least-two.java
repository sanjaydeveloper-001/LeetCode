import java.util.*;

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        // Sort first by end ascending, then start descending
        Arrays.sort(intervals, (a, b) -> 
            a[1] != b[1] ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0]));
        
        int ans = 0;
        int a = -1, b = -1;
        for (int[] interval : intervals) {
            int l = interval[0], r = interval[1];
            // a and b are most recently added elements, always a < b
            boolean inA = (a >= l && a <= r);
            boolean inB = (b >= l && b <= r);
            
            if (inA && inB) continue;
            // Need to add two elements
            if (!inA && !inB) {
                ans += 2;
                a = r - 1;
                b = r;
            } else {
                // Only one is covered, add the largest
                ans += 1;
                // a is always the smaller, so b is the one that's within interval
                a = b;
                b = r;
            }
        }
        return ans;
    }
}