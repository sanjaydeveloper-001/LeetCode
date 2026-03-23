class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        if(arr.length == 1) return 0;
        Arrays.sort( arr, (a,b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int max = arr[0][1];

        for(int i=1; i<arr.length; i++){
            int a = arr[i][0];
            int b = arr[i][1];

            if(a < max){
                count++;
            }
            else{
                max = b;
            }
        }
        return count;
    }
}