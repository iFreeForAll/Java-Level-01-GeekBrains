package Lesson06;

import java.util.Random;

class Cat extends Animal {
    Random rnd = new Random(System.currentTimeMillis());
    int minRunDistance = 100;
    int maxRunDistance = 300;
    int runDistance = minRunDistance + rnd.nextInt(maxRunDistance - minRunDistance + 1);

    double minJumpHeight = 1.0;
    double maxJumpHeight = 3.0;
    double jumpHeight = minJumpHeight + (maxJumpHeight - minJumpHeight) * rnd.nextDouble();

    @Override
    boolean run(int distance) {
        if (distance < runDistance) return true;
        return false;
    }

    @Override
    boolean jump(double height) {
        double maxHeight = 2;
        if (height < jumpHeight) return true;
        return false;
    }

    @Override
    boolean swim(int distance) {
        return false;
    }
}
