class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int l = 0-k;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                if(i-l <= k && i > 0) return false;
                else l = i;
            }
        }
        return true;
    }
}