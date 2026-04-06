class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i:nums){
            if(map.containsKey(i)) map.put(i, map.get(i)+1);
            else map.put(i, 1);
        }

        List<List<Integer>> li = new ArrayList<>();
        li.add(new ArrayList<>());
        
        int n = nums.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<li.size(); j++){
                List<Integer> nl = new ArrayList<>(li.get(j));
                int c = Collections.frequency(nl, nums[i]);
                if(map.get(nums[i]) > c) nl.add(nums[i]);   
                Collections.sort(nl);
                if(!li.contains(nl)) li.add(nl);
            }
        }
        return li;

    }
}