class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) map.put(s.charAt(i), i);
        List<Integer> li = new ArrayList<>();
        
        int st = 0, e = 0;
        for(int i=0; i<s.length(); i++){
            e = Math.max(e, map.get(s.charAt(i)));
            if(i == e) {
                li.add(e-st+1);
                st = i+1;
            }
        }

        return li;

    }
}