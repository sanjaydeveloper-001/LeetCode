class Solution {
    public int[][] generateMatrix(int n) {
        int arr[][] = new int[n][n];
        int count = 1;
        
        int i = -1;
        int j = -1;
        while (count <= n * n) {

            if ( count <= n * n) {
                i++;
                j++;
                for (; j < n && arr[i][j] == 0; j++) {
                    arr[i][j] = count;
                    count++;
                }
               
                j--;
            }

            if (count <= n * n) {
                i++;
                for (; i < n && arr[i][j] == 0; i++) {
                    arr[i][j] = count;
                    count++;
                }
                
                i--;
            }

            if ( count <= n * n) {
                j--;
                for (; j >= 0 && arr[i][j] == 0; j--) {
                    arr[i][j] = count;
                    count++;
                }
                
                j++;
            }

            if (count <= n * n) {
                i--;

                for (; i >= 0 && arr[i][j] == 0; i--) {
                    arr[i][j] = count;
                    count++;

                }
                

            }

        }
        return arr;
    }
}