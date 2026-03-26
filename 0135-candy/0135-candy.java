class Solution {
    public int candy(int[] arr) {
        int n = arr.length;
        int res[] = new int[n];
        Arrays.fill(res,1);
        for(int i=1; i<n; i++){
            if(arr[i] > arr[i-1]){
                res[i] = res[i-1]+1;
            }
        }
        for(int i=n-1; i>0; i--){
            if(arr[i-1] > arr[i]){
                res[i-1] = Math.max(res[i]+1, res[i-1]);
            }
        }
        int sum = 0;
        for(int i:res){ System.out.print(i+" "); sum+=i; }
        return sum;
    }
}