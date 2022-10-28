public class RaceTest {
    final static int NUMRUNNERS = 2;

    public static void main(String[] args) {
        SelfishThread runners[] = new SelfishThread[NUMRUNNERS];

        for (int i = 0; i < NUMRUNNERS; i++) {
            runners[i] = new SelfishThread(i);
        }

        for (int i = 0; i < NUMRUNNERS; i++) {
            runners[i].start();
        }
    }
}
