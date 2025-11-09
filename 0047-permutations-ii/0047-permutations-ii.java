class Solution {
    public List<List<Integer>> permuteUnique(int[] arr) {
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        solve(list, res, 0);
        return res;
    }

    public static void solve(List<Integer> list, List<List<Integer>> res, int idx) {
        if (idx == list.size()) {
            // System.out.println(list);
            res.add(new ArrayList<>(list));
            return;
        }
        HashSet<Integer> used = new HashSet<>();
        for (int i = idx; i < list.size(); i++) {
            if (used.contains(list.get(i))) {
                continue;
            }
            used.add(list.get(i));
            swap(i, idx, list);
            solve(list, res, idx + 1);
            swap(i, idx, list);
        }
    }

    public static void swap(int i, int j, List<Integer> list) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

}