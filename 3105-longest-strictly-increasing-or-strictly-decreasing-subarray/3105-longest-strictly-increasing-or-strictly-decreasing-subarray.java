class Solution {
    public int longestMonotonicSubarray(int[] A) {
        int Ans = 1;

        int CI = 1;
        int CD = 1;
        int Pre = A[0];

        for(int i=1; i<A.length; i++){
            if(Pre < A[i]){
                CI++;
                Ans = Math.max(Ans, Math.max(CI, CD));
                CD = 1;
            }
            else if(Pre > A[i]){
                CD++;
                Ans = Math.max(Ans, Math.max(CI, CD));
                CI = 1;
            }
            else {
                CI = 1;
                CD = 1;
            }
            Pre = A[i];
        }
        
        Ans = Math.max(Ans, Math.max(CI, CD));
        return Ans;
    }
}