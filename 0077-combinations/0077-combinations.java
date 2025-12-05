import java.util.AbstractList;
class Solution {
    private void execute(int n, int k, int index, List<Integer> subset, List<List<Integer>> res) {
        if(subset.size() == k){
            System.out.println("Found subset: " + subset);
            res.add(List.copyOf(subset));
            return;
        }

        for(int i = index; i <= n; i++){
            subset.add(i);
            execute(n, k, i + 1, subset, res);
            subset.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        return new AbstractList<List<Integer>>() {
            List<List<Integer>> res;

            void init() {
                res = new java.util.ArrayList<>();
                execute(n, k, 1, new java.util.ArrayList<>(), res);
            }

            @Override
            public List<Integer> get(int index) {
                return res.get(index);
            }

            @Override
            public int size() {
                if (res == null) {
                    init();
                }
                return res.size();
            }
        };
    }
}