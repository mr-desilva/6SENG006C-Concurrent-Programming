public class Alpha implements Runnable {

//    public Alpha (String name)
//    {
//        super(name);
//    }

    @Override
    public void run() {
        for (int i = 65; i <= 90; i++)
        {
            System.out.println(Thread.currentThread().getName() + " : " + ((char)i));
        }

        for (int i = 97; i <= 122; i++)
        {
            System.out.println(Thread.currentThread().getName() + " : " + ((char)i));
        }
    }
}
