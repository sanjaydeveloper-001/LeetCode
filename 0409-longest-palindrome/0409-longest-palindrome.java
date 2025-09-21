class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        for(char c : s.toCharArray()){
            freq[c]++;
        }

        int count =0;
        boolean hasOdd = false;
        for(int f: freq){
            if(f%2==0) count +=f;
            else{
                count += f -1;
                hasOdd = true;
            }
        }

        if(hasOdd) count +=1;
        return count;
    }
}