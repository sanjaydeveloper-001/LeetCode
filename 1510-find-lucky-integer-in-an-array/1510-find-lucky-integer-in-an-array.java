class Solution {
    public int findLucky(int[] arr) {
        int lucky = -1;
        Arrays.sort(arr);
        int n = arr.length;
        int max = arr[n-1];

        int mat[] = new int[max+1];

        for(int i=0; i<n; i++){
            mat[arr[i]]++;
        }
        for(int i=0; i<max+1; i++){
            if(mat[i] != 0 && mat[i] == i ){
                lucky = i;
            }
        }

        
        return lucky;
    }
    
}