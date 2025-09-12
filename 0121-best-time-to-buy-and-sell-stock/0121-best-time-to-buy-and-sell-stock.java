class Solution {
    public int maxProfit(int[] arr) {
        
        int min = arr[0];
        int pro = 0;

        for(int i=1; i<arr.length; i++){
            if(arr[i] > min) pro = Math.max(arr[i]-min, pro );
            min = Math.min(min, arr[i]);
        }
        return pro;

    }
}