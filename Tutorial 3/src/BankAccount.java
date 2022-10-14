public class BankAccount {
    private String accountNumber;
    private double accountBalance;

    // synchronize mechanism will allow lock and will allow to take the latest value automatically
    // within the synchronized block

    public BankAccount(String accountNumber, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public synchronized double deposit(double depositAmount){
        // using inter thread communication
        while (accountBalance >= 10000){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        accountBalance += depositAmount;
        System.out.println(Thread.currentThread().getName()
                +" After the deposit the current balance is " + accountBalance);
        notifyAll(); // will notify other threads
        return accountBalance;
    }

    public synchronized double withdraw(double withdrawAmount){
        // using inter thread communication
        while (accountBalance < 10000) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(accountBalance >= withdrawAmount) {
            accountBalance -= withdrawAmount;
        } else {
            System.out.println("Not enough balance");
        }

        System.out.println(Thread.currentThread().getName() +
                " After the withdraw current account balance is " + accountBalance);
        notifyAll();

        return accountBalance;
    }

    public synchronized double getAccountBalance() {
        return accountBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
