class Solution {
    public void sortColors(int[] nums) {
        if (nums.length <= 1) {
            System.out.println(Arrays.toString(nums));
            return;
        }
        int i = 0;
        int j = nums.length - 1;
        int arr[] = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int zeroCount = 0;
        int oneCount = 0;
        while (i <= j) {
            if (nums[i] == 0) {
                arr[left] = 0;
                left++;
                zeroCount++;
            } else if (nums[i] == 2) {
                arr[right] = 2;
                right--;
            } else {
                oneCount++;
            }
            i++;
            if (i < j) {
                if (nums[j] == 0) {
                    arr[left] = 0;
                    left++;
                    zeroCount++;
                } else if (nums[j] == 2) {
                    arr[right] = 2;
                    right--;
                } else {
                    oneCount++;
                }
            j--;
            }
        }
        for (int k = zeroCount; k < zeroCount + oneCount; k++) {
            arr[k] = 1;
        }
        System.arraycopy(arr, 0, nums, 0, nums.length);
    }
}