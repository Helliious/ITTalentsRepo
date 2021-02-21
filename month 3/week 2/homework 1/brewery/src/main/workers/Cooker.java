package main.workers;

import main.Brewery;

public class Cooker extends Person implements Runnable {
    private FruitType brandyType;
    private final Brewery brewery;

    public Cooker(String name, int age, Brewery brewery) {
        super(name, age);
        this.brewery = brewery;
    }

    public void setBrandyType(FruitType brandyType) {
        this.brandyType = brandyType;
    }

    @Override
    public FruitType getType() {
        return brandyType;
    }

    @Override
    public int getJobTime() {
        return 1000;
    }

    @Override
    public void run() {
        while (true) {
            brewery.brewCaldron(this);
        }
    }
}
