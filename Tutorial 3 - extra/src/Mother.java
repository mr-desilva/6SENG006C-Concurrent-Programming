public class Mother extends Thread{
    private String name;
    private Plate plate;

    public Mother(String name, Plate plate) {
        super(name);
        this.name = name;
        this.plate = plate;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            plate.putFood("Rice");
            System.out.println("Mother is serving the food Rice");
        }
    }
}
