class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for(int f : nums) sum += f;
        return sum % k;
    }
}