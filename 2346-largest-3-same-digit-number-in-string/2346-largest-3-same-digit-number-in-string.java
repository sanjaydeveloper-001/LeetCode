class Solution {
    public String largestGoodInteger(String s) {
        String best ="";
        
        for(int i = 0; i+2 < s.length(); i++){
            char c = s.charAt(i);
            if( c == s.charAt(i+1) && c == s.charAt(i+2) ){
                best = best.compareTo(s.substring(i, i+3)) > 0 ? best : s.substring(i, i+3);
            }
        }
        return best;
    }
}