public class HouseBasedHusband extends Thread {
    private String name;
    private BankAccount account;

    public HouseBasedHusband(String name, BankAccount account) {
        super(name);
        this.name = name;
        this.account = account;
    }

    @Override
    public void run() {
        for(int i = 0; i<10; i++){
            account.withdraw(10000);
//            System.out.println(Thread.currentThread().getName() +
//                    " After the withdraw current account balance is " + account.getAccountBalance());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
