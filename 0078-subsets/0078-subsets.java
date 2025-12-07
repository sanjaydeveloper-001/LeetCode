class Solution {
    public List<List<Integer>> subsets(int[] arr) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        fun(ans, arr,0,list);
        return list;
        
    }

    public static void fun(List<Integer> ans, int [] arr, int i, List<List<Integer>> list){
        if(i==arr.length){
            list.add(new ArrayList<>(ans));
            return ;
        }
        ans.add(arr[i]);

        fun(ans, arr,i+1,list);
        ans.remove(ans.size() - 1);
        fun(ans,arr,i+1,list);


    }
}