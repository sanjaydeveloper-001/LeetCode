class Solution {

    public static void toChange(char [][] arr ,int i,int j){
        int r = arr.length;
        int c = arr[0].length;

        if(i<0 || j<0 || i>=r || j>=c || arr[i][j] == 'Y' || arr[i][j] == 'X' )
            return;
        arr[i][j]='Y';

        toChange(arr, i, j+1);
        toChange(arr, i+1, j);
        toChange(arr, i-1, j);
        toChange(arr, i, j-1);

    }
    public void solve(char[][] arr) {
        int r = arr.length;
        int c = arr[0].length;

        for(int i =0; i<r; i++){

            if( i==0 || i== r-1){
                for(int j =0; j<c ; j++){
                    if(arr[i][j] == 'O')
                        toChange(arr, i, j);
                }
            }
            else{
                int j = 0;
                if(arr[i][j] == 'O')
                    toChange(arr,i,j);
                j = c-1;
                if(arr[i][j] == 'O')
                    toChange(arr, i, j);
            }
            
        }

        for(int i =0; i<r; i++){
            for(int j=0;j<c; j++){
                if(arr[i][j] == 'Y')
                    arr[i][j] = 'O';
                else{
                    arr[i][j] = 'X';
                }
            }
        }
        
    }
}