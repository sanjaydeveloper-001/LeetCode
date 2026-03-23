class Solution {
    public int findMinArrowShots(int[][] arr) {
        if (arr.length == 0) return 0;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
        int arrow = 0;
        long max = Long.MIN_VALUE;
        for(int i[]:arr){
            if(max < i[0]){
                arrow++;
                max = i[1];
            }
        }

        return arrow;
    }
}