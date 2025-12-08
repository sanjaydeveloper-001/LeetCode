class Solution {
    public int minCostClimbingStairs(int[] arr) {
        int n = arr.length;
        for(int i=2; i<n; i++){
            arr[i] += Math.min(arr[i-1], arr[i-2]);
        }
        return Math.min(arr[n-1], arr[n-2]);
    }
}