import MultithreadingAccount;

public class AccountHolder implements Runnable {
    private Account account;

    public AccountHolder(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 4; i++) {
            makeWithdrawal(2000);
            if (account.getBalance() < 0) {
                System.out.println("Account is overdrawn!");
            }
        }
    }

    private void makeWithdrawal(int withdrawalAmount) {
        if (account.getBalance() >= withdrawalAmount) {
            System.out.println(Thread.currentThread().getName() + " is going to withdraw $" + withdrawalAmount);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {             
            }
            account.withdraw(withdrawalAmount);
            System.out.println(Thread.currentThread().getName() + " completes the withdrawal of $" + withdrawalAmount);
        } else {
            System.out.println("Not enough in account for " + Thread.currentThread().getName() + " to withdram" + 
            account.getBalance());
        }
    }

}