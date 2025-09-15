class Solution {
    public int canBeTypedWords(String str, String s) {
        String [] words = str.split(" ");

        int c = 0;

        for(int i=0; i<words.length; i++){
            int flag = 0;
            for(char ch : s.toCharArray()){
                if( words[i].contains(String.valueOf(ch))) flag = 1;
            }
            if(flag == 0) c++;
        }
        return c;
    }
}