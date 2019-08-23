package Lesson07;

public class MainClass {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Baitik", 6);
        Cat cat2 = new Cat("Rulezzz", 8);
        Cat cat3 = new Cat("Masyanya", 4);
        Cat cat4 = new Cat("Zip", 7);
        Cat cat5 = new Cat("Dos", 6);
        Cat[] cats = {cat1, cat2, cat3, cat4, cat5};

        Plate plate = new Plate(20);
        plate.info();

        for (int i = 0; i < cats.length; i++) {
            System.out.println("Is " + cats[i].getName() + " full: " + cats[i].eat(plate));
            plate.info();
            plate.addFood(1);
        }
    }
}
