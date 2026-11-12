class Solution {
    public int longestMonotonicSubarray(int[] A) {
        int LD = 1;
        int LI = 1;

        int CI = 1;
        int CD = 1;
        int Pre = A[0];

        for(int i=1; i<A.length; i++){
            if(Pre < A[i]){
                CI++;
                LD = Math.max(LD, CD);
                CD = 1;
            }
            else if(Pre > A[i]){
                CD++;
                LI = Math.max(LI, CI);
                CI = 1;
            }
            else {
                LI = Math.max(CI, LI);
                LD = Math.max(CD, LD);
                CI = 1;
                CD = 1;
            }

            Pre = A[i];
        }
        LI = Math.max(CI, LI);
        LD = Math.max(CD, LD);
        return Math.max(LI, LD);
    }
}