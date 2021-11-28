public class Account {
    private int balance = 6000;
    
    public int getBalance() {
        return this.balance;
    }

    public void withdraw(int amount) {
        this.balance = this.balance - amount;
    }
}