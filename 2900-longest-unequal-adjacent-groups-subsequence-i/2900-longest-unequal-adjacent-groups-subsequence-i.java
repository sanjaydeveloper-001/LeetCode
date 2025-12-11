class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int lastGroup = -1;
        for(int i = 0; i < groups.length; ++i) {
            if(lastGroup != groups[i]) {
                result.add(words[i]);
                lastGroup = groups[i];
            }
        }
        return result;
    }
}