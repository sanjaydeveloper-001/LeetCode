class Solution {
    // static {
    //     for (int i = 0; i < 100; i++) {
    //         findLucky(new int[0]);
    //     }
    // }
    public static int findLucky(int[] arr) {
      int count [] = new int [502];
      int max = 1;
      for(int i=0;i<arr.length;i++) {
        count[arr[i]]++;
        max = Math.max(max,arr[i]);
      }
      count[max+1]=-1;
      int i=0 ;
      int lucky=-1;
      while(count[i]!=-1){
        if(count[i]==i && lucky<i){
          lucky = i;
        }
        i++;
      }
      return lucky==0? -1:lucky;
    }
}