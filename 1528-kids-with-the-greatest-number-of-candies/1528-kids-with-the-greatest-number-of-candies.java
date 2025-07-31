class Solution {
    public List<Boolean> kidsWithCandies(int[] can, int eC) {
        int max = 0;
        int n = can.length;

        List<Boolean> li = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(max < can[i]) max = can[i];
        }

        for(int i=0; i<n; i++){
            li.add(can[i]+eC >= max);
        }
        return li;
    }
}