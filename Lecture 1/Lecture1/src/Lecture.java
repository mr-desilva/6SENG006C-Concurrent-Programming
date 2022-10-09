public class Lecture {
    public static void main(String[] args) {
        //System.out.println("Priority : " + Thread.currentThread().getName() + " : " + Thread.currentThread().getPriority());
        // Inheriting from the Thread class
        Thread t1 = new Number("Number 01");
        Thread t2 = new Number("Number 02");
//        Thread t5 = new SimpleThread("SimpleThread 01");

        // Implementing the runnable interface
        Runnable r1 = new Alpha();
        Thread t3 = new Thread(r1, "Alphabet 01");

        Runnable r2 = new Alpha();
        Thread t4 = new Thread(r2, "Alphabet 02");


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        //t5.start();
    }
}
