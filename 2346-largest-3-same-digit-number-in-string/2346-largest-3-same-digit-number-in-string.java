class Solution {
    public String largestGoodInteger(String s) {
        int max = -1;
        String st ="";
        
        for(int i = 2; i < s.length(); i++){
            char c = s.charAt(i);
            if( c == s.charAt(i-1) && c == s.charAt(i-2) ){
                if(Integer.parseInt(String.valueOf(c)) > max){
                    max = (Integer.parseInt(String.valueOf(c)));
                    System.out.println(max);
                    st = "";
                    st+= c;
                    st+=c;
                    st+=c;
                }
            }
        }
        System.out.print(max);
        return st;
    }
}