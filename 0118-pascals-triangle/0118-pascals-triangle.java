class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> li = new ArrayList<>();

        for(int i=0; i<n; i++){
            List<Integer> al = new ArrayList<>();
            al.add(1);

            for(int j=1; j<i && i>1; j++){
                int sum = 0;
                sum += li.get(i-1).get(j-1);
                sum += li.get(i-1).get(j);
                al.add(sum);
            }

            if(i>0) al.add(1);
            li.add(al);
        }

        return li;
    }
}