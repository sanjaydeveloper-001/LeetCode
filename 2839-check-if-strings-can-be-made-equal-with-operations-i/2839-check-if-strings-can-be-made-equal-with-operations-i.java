class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        String s11 = s1;
        int n = s1.length();
        char []ch = s1.toCharArray();
        char []c2 = s11.toCharArray();
        for(int i=0; i<n-2; i++){
            char t = ch[i];
            ch[i] = ch[i+2];
            ch[i+2] = t;
            if((new String(ch).equals(s2))) return true;
        }

        for(int i=n-1; i>1; i--){
            char t = c2[i];
            c2[i] = c2[i-2];
            c2[i-2] = t;
            if((new String(c2).equals(s2))) return true;
        }

        return false;
    }
}