class Solution {
    public boolean wordPattern(String pat, String s) {
        String str[] = s.split(" ");

        if(pat.length() != str.length) return false;
        Map<Character, String> map = new HashMap<>();

        for(int i=0; i<pat.length(); i++){
            char c = pat.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(str[i])) return false;
            }
            else{
                if(map.containsValue(str[i])) return false;
                map.put(c, str[i]);
            }
        }
        return true;
    }
}