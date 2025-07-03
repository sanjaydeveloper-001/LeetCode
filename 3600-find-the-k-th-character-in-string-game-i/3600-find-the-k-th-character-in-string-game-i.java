class Solution {
    public char kthCharacter(int k) {
        String s="a";
        while(s.length() < k ){
            int n=s.length();
            for(int i=0;i<n;i++){
                s+=(char)('a' + ((s.charAt(i) - 'a') + 1) %26 );
            }
        }
        return s.charAt(k-1);
    }
}