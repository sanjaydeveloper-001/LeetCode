class Solution {
    public boolean isPalindrome(int x) {

        int copy = x;
        int pali = 0;
        int num = 10;

        while (copy > 0) {
            pali = (copy % 10) + (pali * num);
            copy /= 10;
        }
        return true ? pali == x : false ;
    }
}