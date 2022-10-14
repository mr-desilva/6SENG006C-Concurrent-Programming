public class CareerMindedWife extends Thread {
    // Using the Java.lang.thread
    private String name;
    private BankAccount account;

    public CareerMindedWife(String name, BankAccount account) {
        super(name);
        this.name = name;
        this.account = account;
    }

    @Override
    public void run() {
        for(int i = 0; i <10; i++){
            double currentBalance = account.deposit(10000);
//            System.out.println(Thread.currentThread().getName()
//                    +" After the deposit the current balance is " + currentBalance);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
