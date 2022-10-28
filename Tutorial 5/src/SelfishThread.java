public class SelfishThread extends Thread{
    public int tick = 1;

    public SelfishThread(int id) {
        super("SelfishRunner-" + id);
    }

    @Override
    public void run() {
        while (tick < 4000000) {
            tick++;
            if ((tick % 50000) == 0) {
                System.out.println(getName() + ": tick = " + tick);
            }
        }
    }
}
