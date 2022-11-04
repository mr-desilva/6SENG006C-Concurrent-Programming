public class MyThread extends Thread {

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("The Thread group name : " + Thread.currentThread().getThreadGroup().getName() +
                    "Thread name : " +
                    Thread.currentThread().getName() + " : " + i);
        }
    }
}
