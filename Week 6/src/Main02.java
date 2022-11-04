public class Main02 {
    public static void main(String[] args) {
        //Thread()
        Thread t1 = new MyThread01();
        t1.start();

        //Thread(String name)
        Thread t2 = new MyThread01("T2");
        t2.start();

        //Thread(ThreadGroup group, String name)
        ThreadGroup group1 = new ThreadGroup("Group 01");
        Thread t3 = new MyThread01(group1,"T3");
        t3.start();

        //Thread(Runnable target)
        Runnable r1 = new RunnableThread();
        Thread t4 = new Thread(r1);
        t4.start();

        //Thread(Runnable target, String name)
        Thread t5 = new Thread(r1, "RunnableThread");
        t5.start();

        //Thread(ThreadGroup group, Runnable target)
        Thread t6 = new Thread(group1, r1);
        t6.start();

        //Thread(ThreadGroup group, Runnable target, String name)
        Thread t7 = new Thread(group1, r1, "Thread T7");
        t7.start();

    }
}
