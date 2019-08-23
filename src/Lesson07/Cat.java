package Lesson07;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public boolean eat(Plate p) {
        if (p.decreaseFood(appetite)) {
            return satiety = true;
        } else {
            return satiety;
        }
    }

    public String getName() {
        return name;
    }
}