class Solution {
    public List<String> getLongestSubsequence(String[] w, int[] g) {
        List<String> li = new ArrayList<>();
        String last = "";
        li.add(w[0]);
        last = w[0];
        for(int i=1; i<g.length; i++){
            if(g[i] != g[i-1]){
                li.add(w[i]);
                last=w[i];
            }
        }

        return li;
    }
}