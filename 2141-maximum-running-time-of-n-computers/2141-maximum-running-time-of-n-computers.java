class Solution {
    public long maxRunTime(int n, int[] arr) {
        Arrays.sort(arr);
        long total = 0;
        for (int x : arr) total += x;
        for (int i = arr.length - 1; i >= 0 && n > 0; i--) {
            long avg = total / n;
            if (arr[i] <= avg) break;

            total -= arr[i];
            n--;
        }
        return n == 0 ? 0 : total / n;
    }
}
