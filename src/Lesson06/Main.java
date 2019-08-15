package Lesson06;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();

        Dog dog1 = new Dog();
        Dog dog2 = new Dog();

        System.out.println(cat1.run(400));
        System.out.println(cat1.jump(1.5));
        System.out.println(cat1.swim(5));
        System.out.println();
        System.out.println(cat2.run(400));
        System.out.println(cat2.jump(1.5));
        System.out.println(cat2.swim(5));
        System.out.println();

        System.out.println(dog1.run(400));
        System.out.println(dog1.jump(1.5));
        System.out.println(dog1.swim(5));
        System.out.println();
        System.out.println(dog2.run(400));
        System.out.println(dog2.jump(1.5));
        System.out.println(dog2.swim(5));
        System.out.println();
    }
}
