public class Child extends Thread{
    private String name;
    private Plate plate;

    public Child(String name, Plate plate) {
        super(name);
        this.name = name;
        this.plate = plate;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            String food = plate.getFood();
            System.out.println("Child is consuming the food " + food);
        }
    }
}
