class Solution {
    public int smallestRepunitDivByK(int k) {
        int count = 1;
        int remainder = 1%k;

        if(k%2 == 0 || k%5 == 0)
        {
            return -1;
        }

        while(remainder != 0){
            remainder = (remainder*10 + 1)%k;
            count++;
        }

        return count;
    }
}