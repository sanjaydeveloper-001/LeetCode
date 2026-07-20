class Solution {
    public int addDigits(int num) {
        if(num <= 9) return num;
        int sum = 0;
        int t = num;
        while(t > 9){
            sum = 0;
            while(t>0){
                sum += t%10;
                t /= 10;
            }
            t = sum;
        }
        return sum;  
    }
}