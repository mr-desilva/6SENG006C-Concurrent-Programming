public class Main {
    public static void main(String[] args) {
        ThreadGroup group[] = new ThreadGroup[6];
        Thread threads[] = new Thread[7];

        group[0] = Thread.currentThread().getThreadGroup();
        group[1] = new ThreadGroup(group[0],"Group A");
        group[2] = new ThreadGroup(group[0],"Group B");
        group[3] = new ThreadGroup(group[0],"Group C");
        group[4] = new ThreadGroup(group[2],"Group B1");
        group[5] = new ThreadGroup(group[2],"Group B2");

        threads[0] = new MyThread(group[0], "Thread 1");
        threads[1] = new MyThread(group[1], "Thread 2");
        threads[2] = new MyThread(group[1], "Thread 3");
        threads[3] = new MyThread(group[3], "Thread 4");
        threads[4] = new MyThread(group[4], "Thread 5");
        threads[5] = new MyThread(group[4], "Thread 6");
        threads[6] = new MyThread(group[5], "Thread 7");

        for(int i= 0; i < 7; i++){
            threads[i].start();
        }

        int active = group[0].activeCount();
        Thread threads2[] = new Thread[active * 2];
        group[0].enumerate(threads2);

        // Using enumerate method  with thread array is the parameter
        for(int i = 0; i < active * 2; i++) {
            if(threads2 != null) {
                System.out.println(threads2[i].getName());
            }
        }

        int active1 = group[0].activeCount();
        Thread threads3[] = new Thread[active1 * 2];
        group[0].enumerate(threads3, true);

        // Using enumerate with thread array and recursive as false
        for(int i = 0; i < threads3.length; i++) {
            if(threads3 != null) {
                System.out.println(threads2[i].getName());
            }
        }

        int activeGroupCount = group[0].activeGroupCount();
        ThreadGroup activeThreadGroup[] = new ThreadGroup[activeGroupCount*2];
        group[0].enumerate(activeThreadGroup);

        // Using enumerate with thread group array
        for(int i = 0; i < activeThreadGroup.length; i++) {
            if(activeThreadGroup != null) {
                System.out.println(activeThreadGroup[i].getName());
            }
        }

        int activeGroupCount2 = group[0].activeGroupCount();
        ThreadGroup activeThreadGroup2[] = new ThreadGroup[activeGroupCount2*2];
        group[0].enumerate(activeThreadGroup2, false);


        // Using enumerate with thread group array and recursive as false
        for(int i = 0; i < activeThreadGroup2.length; i++) {
            if(activeThreadGroup2 != null) {
                System.out.println(activeThreadGroup2[i].getName());
            }
        }

        // Interrupting all the threads
        group[0].interrupt();
        group[1].interrupt();
        group[2].interrupt();
        group[3].interrupt();
        group[4].interrupt();


    }
}
