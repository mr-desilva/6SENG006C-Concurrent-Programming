public class Main {
    public static void main(String[] args) {
        //using Java.lang.thread
        BankAccount bankAccount = new BankAccount("acc001",0.0);

        Thread cmw = new CareerMindedWife("Career Minded Wife", bankAccount);
        Thread hbh = new HouseBasedHusband("House Based Husband", bankAccount);

        cmw.start();
        hbh.start();
    }
}
