class Solution {
    public List<Boolean> kidsWithCandies(int[] can, int eC) {
        int max = 0;
        int n = can.length;

        List<Boolean> li = new ArrayList<>();

        for(int i=0; i<n; i++){
            max= Math.max(max, can[i]);
        }

        for(int i=0; i<n; i++){
            if(can[i] + eC >= max){
                li.add(true);
            }
            else{
                System.out.print(can[i]+eC+" ");
                li.add(false);
            }
        }
        return li;
    }
}