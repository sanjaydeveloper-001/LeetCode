class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        
        int n = words.length;
        int d = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(words[i].equals(target)){
                int cw = (i - startIndex + n)%n;
                int acw = (startIndex - i + n)%n;
                d = Math.min(d, Math.min(cw, acw));
            }
        }
        return d == Integer.MAX_VALUE ? -1 : d;
    }
}