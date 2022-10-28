public class Main {
    public static void main(String[] args) {
        System.out.println("Name " + Thread.currentThread().getName()); // main
        System.out.println("Thread group Name " + Thread.currentThread().getName()); //main

        //when you dont spcify the a parent the thrad group will be placed in the thead group to which the thread which is creating the thread group as the parent
        ThreadGroup tg1 = new ThreadGroup("TG01");
        System.out.println("Who is the parent of tg1?" + tg1.getParent().getName());

        ThreadGroup tg2 = new ThreadGroup(tg1, "TG02");

        Thread t1 = new Thread("T1"); //who created this thread object > main
        // which thread group to which main thread belongs to? main thread group
        // which thread group to which T1 thread belongs to? main thread group

        Thread t2 = new Thread(tg1, "T2"); //who created this thread object > main
        // which thread group to which main thread belongs to? tg1 thread group
        // which thread group to which T2 thread belongs to? tg1 thread group
    }
}
