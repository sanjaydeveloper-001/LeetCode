class Solution {
    public int totalMoney(int n) {
        int bal = 0;
        int amt = 1;
        int week = 1;
        for(int i=0; i<n; i++){
            if(amt == week+7){
                week++;
                amt = week;
            }
            bal += amt;
            System.out.print(amt+" ");
            amt++;
        }
        return bal;
    }
}