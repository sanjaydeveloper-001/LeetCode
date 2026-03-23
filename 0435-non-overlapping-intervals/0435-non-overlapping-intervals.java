class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        if(arr.length == 1) return 0;
        Arrays.sort( arr, (a,b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int max = arr[0][1];

        for(int i=1; i<arr.length; i++){
            if(arr[i][0] < max) count++;
            else max = arr[i][1];
        }
        return count;
    }
}