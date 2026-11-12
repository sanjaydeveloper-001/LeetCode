class Solution {
    public int longestMonotonicSubarray(int[] A) {
        int Ans = 1;
        int CI = 1;
        int CD = 1;

        for(int i=1; i<A.length; i++){
            if(A[i-1] < A[i]){
                CI++;
                CD = 1;
            }
            else if(A[i-1] > A[i]){
                CD++;
                CI = 1;
            }
            else {
                CI = 1;
                CD = 1;
            }
            Ans = Math.max(Ans, Math.max(CI, CD));
        }
        
        return Ans;
    }
}