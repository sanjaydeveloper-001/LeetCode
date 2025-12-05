class Solution {
    public int countPartitions(int[] nums) {
        int right = 0;
        int left = 0;
        int even = 0;
        for(int i=0; i<nums.length; i++){ right += nums[i];}
        for(int i=0; i<nums.length-1; i++){
            left += nums[i];
            right -= nums[i];
            if((left - right)%2 ==0 ) even++;
        }
        return even;
    }
}