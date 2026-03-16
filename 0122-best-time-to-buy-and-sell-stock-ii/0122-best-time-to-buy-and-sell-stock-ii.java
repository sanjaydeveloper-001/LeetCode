class Solution {
    public int maxProfit(int[] arr) {
        int p = 0;
        int min = arr[0];

        for(int i=1; i<arr.length; i++){
            int c_p = 0;
            if(min > arr[i]) min =arr[i]; 
            else if(min < arr[i]) {
                c_p = arr[i]-min;
                min = arr[i];
            }

            p=Math.max(p+c_p, c_p);
        }

        return p;
    }
}