class Solution {
    public void reverseString(char[] s) {
        
        String st = new String(s);
        int index = 0;
        for(int i=s.length-1; i>=0; i--){
            s[index] = st.charAt(i);
            index++;
        }

    }
}