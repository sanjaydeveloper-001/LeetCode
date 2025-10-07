class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] fa = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            fa[i] = i;
        }

        int[] ans = new int[n];
        Map<Integer, Integer> fullDay = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake == 0) {
                ans[i] = 1;
                continue;
            }
            Integer j = fullDay.get(lake);
            if (j != null) {
                int dryDay = find(j + 1, fa);
                if (dryDay >= i) {
                    return new int[]{};
                }
                ans[dryDay] = lake;
                fa[dryDay] = find(dryDay + 1, fa); 
            }
            ans[i] = -1;
            fa[i] = i + 1;
            fullDay.put(lake, i);
        }
        return ans;
    }

    private int find(int x, int[] fa) {
        if (fa[x] != x) {
            fa[x] = find(fa[x], fa);
        }
        return fa[x];
    }
}