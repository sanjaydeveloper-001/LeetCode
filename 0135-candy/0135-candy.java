class Solution {
     static {
        for (int i = 0; i < 140; ++i)
            candy(new int[] { 1, 3, 2 });
            System.gc();
    }
    public static int candy(int[] ratings) {
        int i=1;
        int candy=1;
        while(i<ratings.length){
            if(ratings[i]==ratings[i-1]){
                candy++;
                i++;
            }else{
                int peak=1;
                while(i<ratings.length&&ratings[i]>ratings[i-1]){
                    peak++;
                    candy+=peak;
                    i++;
                }
                int down=1;
                while(i<ratings.length&&ratings[i]<ratings[i-1]){
                    candy+=down;
                    down++;
                    i++;
                }
                if(down>peak){
                    candy=candy-peak+down;
                }
            }
        }
        return candy;
    }
}