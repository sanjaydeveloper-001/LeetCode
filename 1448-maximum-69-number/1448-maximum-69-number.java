class Solution {
    public int maximum69Number (int n) {
        char [] dig = String.valueOf(n).toCharArray();
        for(int i=0; i<dig.length; i++){
            if(dig[i] == '6'){
                dig[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(dig));
    }
}