class Solution {
    public int longestSubarray(int[] nums) {

        int count =0;
        int pos = -1;
        int n = nums.length;

        boolean check = true;
        for(int i =0; i<n; i++){
            if(nums[i] == 0) check = false;
        }

        if(check){
            return n-1;
        }

        for(int i=0; i<n; i++){

            int c = 0;
            boolean z = false;
            if( nums[i] == 1){
                for(int j = i; j<n; j++){
                    if(nums[j] == 1) c ++;
                    else if(z == false){
                        z= true;
                    }
                    else{
                        break;
                    }
                }
            }

            count = Math.max(count , c);
        }
        
        return count;
    }
}