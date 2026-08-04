class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer> li = new ArrayList<>();
        int j = 0;
        int i = nums[0];
        while(i <= nums[n-1]){
            if(i != nums[j]) li.add(i);
            else j++;

            i++;
        }

        return li;
        
    }
}