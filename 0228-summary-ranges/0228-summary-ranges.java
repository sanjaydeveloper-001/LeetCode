class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> arr=new ArrayList<>();
        if(nums.length==0) return arr;
        if(nums.length==1){
            arr.add(String.valueOf(nums[0]));
            return arr;
        }
        for(int  i=1;i<nums.length;i++){
            StringBuilder sb=new StringBuilder();
            if((nums[i-1]+1)!=(nums[i])){
                sb.append(nums[i-1]);
            }
            else if((nums[i-1]+1)==(nums[i])){
                sb.append(nums[i-1]).append("->");
                while(i<nums.length && (nums[i-1]+1)==(nums[i])){
                    i++;
                }
                sb.append(nums[i-1]);
            }
            arr.add(sb.toString());
        }
        if (nums.length == 1 || nums[nums.length - 2] + 1 != nums[nums.length - 1]) {
            arr.add(String.valueOf(nums[nums.length - 1]));
        }
        return arr;
    }
}