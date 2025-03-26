class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[]arr=mergeArr(nums1,nums2);
        int n=arr.length;
        Arrays.sort(arr);
        double s=1.0;
        if(n==1){
            s=arr[0];
            return s;
        }
        else if(n%2!=0){
            s=arr[n/2];
            return s;
        }
        else{
            s=(arr[n/2] + arr[n/2 -1]) /2.0;
            return s;
        }
    }
    public int[] mergeArr(int[] arr1, int[] arr2){
        int n=arr1.length;
        int m=arr2.length;
        int []arr=new int[n+m];
        int j=0;

        for(int i=0;i<n+m;i++){
            if(i<n){
                arr[i]=arr1[i];
            }
            else{
                arr[i]=arr2[j];
                j++;
            }
        }
        return arr;
    }
}
