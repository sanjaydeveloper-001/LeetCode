class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
       return decode(0,s,n,dp);
    }
    private int decode(int i,String s,int n,int[] dp)
    {
        if(i==n)
        return dp[i]=1;
        if(s.charAt(i)=='0')
        return dp[i]=0;
        if(dp[i]!=-1)
        return dp[i];
        int res=decode(i+1,s,n,dp);
        if(i+1<n){
            if(s.charAt(i)=='1'||(s.charAt(i)=='2'&&s.charAt(i+1)<='6'))
            res+=decode(i+2,s,n,dp);
        }
        return dp[i]=res;
    }
}