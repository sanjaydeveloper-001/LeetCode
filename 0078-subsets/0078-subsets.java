class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> li = new ArrayList<>();
        li.add(new ArrayList<>());
        
        int n = nums.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<li.size(); j++){
                List<Integer> nl = new ArrayList<>(li.get(j));
                if(!nl.contains(nums[i])){
                    nl.add(nums[i]);
                    li.add(nl);
                }
            }
        }
        return li;
    }

}