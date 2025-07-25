class Solution {
    public int maxSum(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        
        for(int num : set){
            if(num > 0) res += num;
        }

        if(res == 0){
            res = Collections.max(set);
        }
        return res;
    }
}