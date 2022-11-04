public class ThreadGroups {
    public static void main(String[] args) {
        Thread t1 = new Thread(); //main thread creates this thread therefore this thread is
        // placed in the main thread group why ?
        // what would be name of the thread ?
        System.out.println("Name of the t1 thread : " + t1.getName());
        // what is the thead group to which this thead will be put on?
        System.out.println("Name of the thread group which t1 belongs to : " + t1.getThreadGroup().getName());

        ThreadGroup group1 = new ThreadGroup("Thread Group 01");
        System.out.println("Thread group 01's parent name " + group1.getParent().getName());

        Thread t2 = new Thread(group1, "Thread02");
        System.out.println("Thread name of t2 : " + t2.getName() + " parent of t2 : " + t2.getThreadGroup().getName());
    }
}
