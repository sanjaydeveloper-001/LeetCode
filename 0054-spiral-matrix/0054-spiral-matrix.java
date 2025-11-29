class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        List<Integer> li = new ArrayList<>();
        int t = 0;
        int l = 0;
        int r = arr[0].length;
        int b = arr.length;

        while( t<b && l<r){
            for(int i=l; i<r; i++){
                li.add(arr[t][i]);
            }            
            t++;

            for(int i=t; i<b; i++){
                li.add(arr[i][r-1]);
            }
            r--;
            
            if(t < b){
                for(int i=r-1; i>=l; i--){
                    li.add(arr[b-1][i]);
                }
                b--;
            }

            if( l < r){
                for(int i=b-1; i>=t; i--){
                    li.add(arr[i][l]);
                }
                l++;
            }
        }

        return li;
    }
}