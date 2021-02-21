package main.workers;

import main.Brewery;

import java.util.Random;

public class Gatherer extends Person implements Runnable {
    private final FruitType fruitType;
    private final Brewery brewery;

    public Gatherer(String name, int age, Brewery brewery) {
        super(name, age);
        Random random = new Random();
        int chance = random.nextInt(3);
        switch (chance) {
            case 0:
                fruitType = FruitType.GRAPE;
                break;
            case 1:
                fruitType = FruitType.APRICOT;
                break;
            default:
                fruitType = FruitType.PLUM;
                break;
        }
        this.brewery = brewery;
    }

    @Override
    public FruitType getType() {
        return fruitType;
    }

    @Override
    public int getJobTime() {
        return 200;
    }

    @Override
    public void run() {
        while (true) {
            brewery.fillCaldron(getType());
            try {
                Thread.sleep(getJobTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
