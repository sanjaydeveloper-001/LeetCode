class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            if(nums[i]>max) {
                max = nums[i];
            }
        }
        int[] arr = new int[max+1];
        for(int i=0;i<n;i++) {
            arr[nums[i]]++;
        }
        int maxFreq = 0;
        int count = 0;
        for(int i=0;i<arr.length;i++) {
            if(maxFreq<arr[i]) {
                maxFreq = arr[i];
                count = 1;
            } else if (maxFreq == arr[i]) {
                Math.max(maxFreq,++count);
            }

        }
        return count*maxFreq;
    }
}