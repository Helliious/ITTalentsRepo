package main.util;

import java.util.Random;

public class Randomizator {
    public static int getRandNum(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
