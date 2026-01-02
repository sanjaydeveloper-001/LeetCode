class Solution {
    public int countNegatives(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int cou = 0;

        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                if(arr[i][j] < 0) cou++;
                else break;
            }
        }

        return cou;
    }
}