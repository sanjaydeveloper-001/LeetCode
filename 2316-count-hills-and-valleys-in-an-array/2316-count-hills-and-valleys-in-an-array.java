class Solution {
    public int countHillValley(int[] nums) {
        
        int n = nums.length;
        int left = 0;
        int count = 0;

        for(int i = 1; i < n; i++){
            if(nums[i] == nums[left]) continue;

            int right = i+1;

            while(right < n && nums[i] == nums[right]) right++;

            if(right == n) break;

            if(nums[i] < nums[left] && nums[i] < nums[right]) count++;

            else if (nums[i] > nums[left] && nums[i] > nums[right]) count++;

            left = i;
        }

        return count;
    }
}