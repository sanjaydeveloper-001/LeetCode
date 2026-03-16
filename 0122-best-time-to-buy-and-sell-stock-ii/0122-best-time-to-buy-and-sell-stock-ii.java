class Solution {
    public int maxProfit(int[] arr) {
        int p = 0;
        int st = arr[0];

        for(int i=1; i<arr.length; i++){
            int c_p = 0; 
            if(st < arr[i]) {
                c_p = arr[i]-st;
            }
            st = arr[i];
            p += c_p;
        }

        return p;
    }
}