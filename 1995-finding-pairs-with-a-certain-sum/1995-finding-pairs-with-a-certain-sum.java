class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private int[] freq;  // Frequency count of nums2 values in range [0, 1000]

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.freq = new int[999999]; // Since 0 <= nums2[i] <= 1000

        for (int num : nums2) {
            freq[num]++;
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];
        int newVal = oldVal + val;

        // Update frequency map
        if (oldVal >= 0 && oldVal <= 999999) {
            freq[oldVal]--;
        }
        if (newVal >= 0 && newVal <= 999999) {
            freq[newVal]++;
        }

        // Update the value in nums2
        nums2[index] = newVal;
    }

    public int count(int tot) {
        int count = 0;
        for (int n : nums1) {
            int target = tot - n;
            if (target >= 0 && target <= 999999) {
                count += freq[target];
            }
        }
        return count;
    }
}