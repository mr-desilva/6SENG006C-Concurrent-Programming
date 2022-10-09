public class Number extends Thread{
    // Lecture and Tutorial 1
    //running two threads at once

    public Number (String name)
    {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Priority : " + Thread.currentThread().getName() + " : " + Thread.currentThread().getPriority());
        for (int i = 1; i <= 100; i++)
        {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
