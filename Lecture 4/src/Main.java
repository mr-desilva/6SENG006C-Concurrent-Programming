public class Main {
    public static void main(String[] args) {
        // Daemon - background
        Runnable myThread1 = new MyThread();
        Runnable myThread2 = new MyThread();
        Thread th1 = new Thread(myThread1, "Thread 01");
        Thread th2 = new Thread(myThread2,"Thread 02");

        System.out.println("State of the thread 01 : " + th1.getState());
        System.out.println("thread 01 current isAlive : " + th1.isAlive());
        System.out.println("thread 01 current priority : " + th1.getPriority());
        System.out.println("thread 01 isDaemon : " + th1.isDaemon());
        //setting the thread to the  daemon thread
        th1.setDaemon(true);



        th1.start();
        try {
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
        }

        th2.start();

        System.out.println("thread 01 current state after starting : " + th1.getState());
        System.out.println("thread 01 current isAlive : " + th1.isAlive());
    }
}
