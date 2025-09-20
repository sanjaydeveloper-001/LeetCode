class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map=new HashMap<>();
        String[] array=s.split(" ");
        HashSet<String> set=new HashSet<>();
        if(pattern.length()!=array.length) return false;
        for(int i=0;i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!array[i].equals(map.get(pattern.charAt(i)))) return false;
            }else{
                if(set.contains(array[i]))return false;
                map.put(pattern.charAt(i),array[i]);
                set.add(array[i]);
            }
        }
        return true;
    }
}