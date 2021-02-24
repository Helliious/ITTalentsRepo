package workers;

import main.Brewery;
import main.Caldron;
import main.FruitType;

public class Gatherer implements Runnable {
    private final FruitType fruitType;
    private final Brewery brewery;

    public Gatherer(Brewery brewery) {
        this.brewery = brewery;
        this.fruitType = FruitType.GRAPE;
    }

    @Override
    public void run() {
        Caldron caldron = brewery.getNonFullCaldron();
        while (true) {
            if (caldron.isFull()) {
                System.out.println("Filled Caldron!");
                caldron = brewery.getNonFullCaldron();
            }
            if (caldron != null) {
                caldron.fill();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
