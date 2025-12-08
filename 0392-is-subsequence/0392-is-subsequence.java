class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        if( s.length() == 0) return true;
        for(char c : t.toCharArray()){
            if( s.charAt(i) == c) i++;
            if( i == s.length()) return true;
        }
        return false;
    }
}