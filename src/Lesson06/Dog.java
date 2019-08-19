package Lesson06;

import java.util.Random;

class Dog extends Animal {
    Random rnd = new Random(System.currentTimeMillis());
    int minRunDistance = 400;
    int maxRunDistance = 600;
    int runDistance = minRunDistance + rnd.nextInt(maxRunDistance - minRunDistance + 1);

    double minJumpHeight = 0.1;
    double maxJumpHeight = 0.9;
    double jumpHeight = minJumpHeight + (maxJumpHeight - minJumpHeight) * rnd.nextDouble();

    int minSwimDistance = 2;
    int maxSwimDistance = 10;
    int swimDistance = minSwimDistance + rnd.nextInt(maxSwimDistance - minSwimDistance + 1);

    @Override
    boolean run(int distance) {
        int maxDistance = 500;
        if (distance < runDistance) return true;
        return false;
    }

    @Override
    boolean jump(double height) {
        double maxHeight = 0.5;
        if (height < jumpHeight) return true;
        return false;
    }

    @Override
    boolean swim(int distance) {
        int maxDistance = 10;
        if (distance < swimDistance) return true;
        return false;
    }
}
