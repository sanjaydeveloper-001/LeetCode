class Solution {
    public int maxRepeating(String sequence, String word) {
        int l=sequence.length();
        int n=word.length();
        int ans=0;
        int count=0;
        int start=0;
        for(int i=0;i<=l-n;){
            if(sequence.substring(i, i+n).equals(word) && i<=l-n){
                if(count==0) start=i;
                count++;
                i=i+n;
            }else{ 
                ans = Math.max(ans, count);
                if(count>0){
                    i=start+1;
                }else{
                    i++;
                }
                count = 0;
            }
        }
        return Math.max(count, ans);
    }
}