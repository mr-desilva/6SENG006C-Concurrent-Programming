public class Plate {
    private String food;
    private boolean foodAvailable = true;

    public Plate(String food) {
        this.food = food;
    }

    public synchronized String getFood(int num) {
        while (!foodAvailable){
            try {
                System.out.println(Thread.currentThread().getName() + "WAIT");
                wait(100);
                System.out.println(Thread.currentThread().getName() + " END WAIT");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        if (isFoodAvailable()) {
            // Child is consuming the food
            //this.food = "";
            this.foodAvailable = false;
            System.out.println(Thread.currentThread().getName() + " : Consuming : " + num);
//        }
//        else {
//            System.out.println(Thread.currentThread().getName() + " : Consuming : " + num);s
//
//        }


        notifyAll(); // Notifies the mother to serve the food
        return food;
    }

    public boolean isFoodAvailable() {
        return foodAvailable;
    }

    public synchronized void putFood(String food){
        while (foodAvailable){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Mother serves the food
        this.food = food;
        this.foodAvailable = true;
        notifyAll(); // Notifies the child to consume the food
    }
}
