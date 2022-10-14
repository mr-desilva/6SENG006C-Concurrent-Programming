public class HouseBasedHusband implements Runnable{

    private BackAccount account;
    private String name;

    public HouseBasedHusband(BackAccount account,String name){
        super();
        this.account = account;
        this.name= name;
    }

    public String getName(){
        return this.name;
    }
    @Override
    public void run() {
        double withdrawAmount = 10000;
        try{
        for(int i= 0; i<=10;i++){
            //System.out.println(this.name+" Account Balance after performing withdraw operation "+this.account.withdraw(withdrawAmount));
            this.account.withdraw(withdrawAmount);
            //Thread.sleep(100);
        }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
