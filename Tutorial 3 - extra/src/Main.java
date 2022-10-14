public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate("Rice");

        Thread mw = new Mother("Mother Thread", plate);
        Thread cw = new Child("Child Thread", plate);

        mw.start();
        cw.start();
    }
}
