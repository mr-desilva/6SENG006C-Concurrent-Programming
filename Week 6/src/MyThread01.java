public class MyThread01 extends Thread {

    public MyThread01(){
        super();
    }

    public MyThread01(String name){
        super(name);
    }

    public MyThread01(ThreadGroup group, String name){
        super(group, name);
    }



    @Override
    public void run() {
        ThreadGroup group2 = new ThreadGroup("Thread 02");
        System.out.println("The parent of group 2 is " + group2.getParent().getName());
        for(int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
