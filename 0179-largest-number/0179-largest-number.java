class Solution {
    public String largestNumber(int[] nums) {
        String[] a = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(a, (x, y) -> (y + x).compareTo(x + y));
        StringBuilder s = new StringBuilder();
        for (String x : a) {
            s.append(x);
        }
        while (s.length() > 1 && s.charAt(0) == '0') {
            s.deleteCharAt(0);
        }
        return s.toString();
    }
}