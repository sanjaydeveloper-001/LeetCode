class Solution {
    public List<String> getLongestSubsequence(String[] w, int[] g) {
        List<String> li = new ArrayList<>();
        int last = -1;
        for(int i=0; i<g.length; ++i){
            if(last != g[i]){
                li.add(w[i]);
                last=g[i];
            }
        }
        return li;
    }
}