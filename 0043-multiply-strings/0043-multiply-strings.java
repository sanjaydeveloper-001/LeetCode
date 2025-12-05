class Solution {
    public String multiply(String num1, String num2) {
        
        long s = Integer.parseInt(num1);
        long t = Integer.parseInt(num2);
        long mul = s*t;
        return String.valueOf(mul);
    }
}