class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int result[]=new int[] {-1,-1} ;
        int i=0,j=n-1;

        for(i=0;i<n;i++){
            if(nums[i]==target){
                result[0]=i;
                break;
            }
        }
        for(j=n-1; j>=i ; j--){
            if(nums[j]==target){
                result[1]=j;
                break;
            }
        }
        return result;
    }
}