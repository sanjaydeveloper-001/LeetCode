class Solution {
    public int pivotInteger(int n) {
        int sumOfN = (n*(n+1))/2;
        int pivot = (int) Math.sqrt(sumOfN);
        return pivot * pivot == sumOfN ? pivot : -1;
    }
}
