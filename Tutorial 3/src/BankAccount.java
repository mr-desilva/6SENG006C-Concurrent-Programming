public class BankAccount {
    private String accountNumber;
    private double accountBalance;

    // synchronize mechanism will allow lock and will allow to take the latest value automatically
    //within the synchronized block

    public BankAccount(String accountNumber, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public synchronized double deposit(double depositAmount){
        accountBalance += depositAmount;
        System.out.println(Thread.currentThread().getName()
                +" After the deposit the current balance is " + accountBalance);
        return accountBalance;
    }

    public synchronized double withdraw(double withdrawAmount){
        if(accountBalance >= withdrawAmount) {
            accountBalance -= withdrawAmount;
        } else {
            System.out.println("Not enough balance");
        }

        System.out.println(Thread.currentThread().getName() +
                " After the withdraw current account balance is " + accountBalance);

        return accountBalance;
    }

    public synchronized double getAccountBalance() {
        return accountBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
