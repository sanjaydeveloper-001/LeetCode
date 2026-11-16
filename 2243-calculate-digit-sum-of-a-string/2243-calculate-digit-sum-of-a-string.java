class Solution {
    public String digitSum(String s, int k) {

        while(true){
            if(s.length() <= k) break;
            String R = "";
            for(int i=0; i<s.length(); i+=k){
                String T = s.substring(i, i+k <= s.length() ? i+k : s.length());
                int t = 0;
                for(char c : T.toCharArray()) t += c-'0';
                R += String.valueOf(t);
            }
            s = R;
        }
        return s;
    }
}