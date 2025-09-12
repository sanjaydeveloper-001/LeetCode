class Solution {
    public int titleToNumber(String columnTitle) {
        int count=0;
        for(int i=0;i<columnTitle.length();i++){
            int num=columnTitle.charAt(i)-'A'+1;
          count=count*26+num;
        //   System.out.println(count);
        //   if(i+1<columnTitle.length()){
        //     count*=26;
        //   }
        }
        return count;
    }
}