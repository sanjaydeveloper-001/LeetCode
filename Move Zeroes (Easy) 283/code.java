class Solution {
    public void moveZeroes(int[] nums) {
        int r=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int t=nums[i];
                nums[i]=nums[r];
                nums[r]=t;
                r++;
            }
        }
    }
}