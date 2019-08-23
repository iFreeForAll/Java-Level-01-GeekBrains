package Lesson07;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if(food < n) {
            return false;
        } else {
            food -= n;
            return true;
        }
    }

    public void addFood(int n) {
        food += n;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
