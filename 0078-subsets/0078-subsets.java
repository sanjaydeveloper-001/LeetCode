class Solution {
    List<List<Integer>> recur(int ind, int[] nums, List<List<Integer>> subs, int len, List<Integer> curr) {
        if(ind == len) {
            subs.add(new ArrayList<>(curr));
            return subs;
        }

        curr.add(nums[ind]);
        recur(ind+1, nums, subs, len, curr);

        curr.remove(curr.size() - 1);
        recur(ind+1, nums, subs, len, curr);

        return subs;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subs = new ArrayList<>();
        return recur(0, nums, subs, nums.length, new ArrayList<>());
    }
}