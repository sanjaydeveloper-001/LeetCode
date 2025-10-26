class Bank {

    private long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1-1 >= balance.length || account2-1 >= balance.length) return false;
            
        if(withdraw(account1, money)) {
            return deposit(account2, money);
        }

        return false;
    }
    
    public boolean deposit(int account, long money) {
        if(account-1 < balance.length) {
            this.balance[account-1] += money;
            return true;
        }

        return false;
    }
    
    public boolean withdraw(int account, long money) {
        if(account-1 >= this.balance.length) return false;

        if(this.balance[account-1] < money) return false;

        this.balance[account-1] -= money;
        return true;
    }
}
