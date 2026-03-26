class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int pro = 0;

        int stack = arr[0];
        for(int i=1; i<n; i++){
            if(arr[i] > stack) pro+= arr[i]-stack;
            stack = arr[i];
        }

        return pro;
    }
}