public class Plate {
    private String food;
    private boolean foodAvailable = true;

    public Plate(String food) {
        this.food = food;
    }

    public synchronized String getFood() {
        while (!foodAvailable){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Child is consuming the food
        this.foodAvailable = false;
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
