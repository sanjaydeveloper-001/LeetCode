class Solution {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        char[] arr=new char[26];

        for(int i=0;i<s.length();i++) {
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }

        for(int i:arr) {
            if(i!=0) return false;
        }

        return true;
    }
}