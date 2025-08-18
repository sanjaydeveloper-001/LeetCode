class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> freq2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        freq2 = new HashMap<>();
        for (int num : nums2) {
            freq2.put(num, freq2.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];
        freq2.put(oldVal, freq2.get(oldVal) - 1);

        nums2[index] += val;
        int newVal = nums2[index];
        freq2.put(newVal, freq2.getOrDefault(newVal, 0) + 1);
    }

    public int count(int tot) {
        int res = 0;
        for (int a : nums1) {
            int b = tot - a;
            res += freq2.getOrDefault(b, 0);
        }
        return res;
    }
}
