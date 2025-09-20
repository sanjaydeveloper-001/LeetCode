class Solution {
    public void reverseString(char[] s) {
        String st = new String(s);
        int j=0;
        for(int i=s.length-1; i>=0; i--){ s[i] = st.charAt(j); j++; }
    }
}