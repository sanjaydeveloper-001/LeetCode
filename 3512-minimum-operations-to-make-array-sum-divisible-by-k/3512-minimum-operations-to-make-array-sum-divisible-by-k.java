class Solution {
    public int minOperations(int[] nums, int k) {
        int c=0;
        if(check(nums, k)) return 0;
        for(int i=0; i<nums.length; i++){
            while(nums[i] > 0){
                c++;
                nums[i]--;
                if(check(nums, k)) {
                    return c;
                }
            }
        }
        return c;
    }
    public boolean check(int [] arr, int k){
        int sum = 0;
        for(int f : arr) sum += f;
        if(sum % k == 0) return true;
        return false;
    }
}