package main;

import main.workers.Cooker;
import main.workers.FruitType;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Caldron {
    private static final int MAX_CAPACITY = 10;
    private final BlockingQueue<Integer> fillAmount;
    private final ConcurrentHashMap<FruitType, Integer> brandies;
    private FruitType fruitType;

    Caldron() {
        fillAmount = new ArrayBlockingQueue<>(MAX_CAPACITY);
        brandies = new ConcurrentHashMap<>();
        fruitType = null;
    }

    public void showProducedAlcohol() {
        System.out.println("Produced " + brandies.get(fruitType) + "liters of " + fruitType + " brandy!");
    }

    public int getBrandyType() {
        if (brandies.get(fruitType) == null) {
            return 0;
        }
        return brandies.get(fruitType);
    }

    public boolean isFull() {
        return fillAmount.size() == MAX_CAPACITY;
    }

    public boolean isEmpty() {
        return fillAmount.isEmpty();
    }

    void checkFruit(FruitType fruitType) {
        if (this.fruitType == null) {
            this.fruitType = fruitType;
        }
    }

    public void fill(FruitType fruitType) {
        checkFruit(fruitType);
        if (this.fruitType == fruitType) {
            try {
                fillAmount.put(1);
                System.out.println("Gathered 1kg of " + this.fruitType + " fruit!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void brew(Cooker cooker) {
        while (!fillAmount.isEmpty()) {
            try {
                fillAmount.take();
                Thread.sleep(cooker.getJobTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cooker.setBrandyType(fruitType);
            if (!brandies.containsKey(cooker.getType())) {
                brandies.put(cooker.getType(), 0);
            }
            brandies.put(cooker.getType(), brandies.get(cooker.getType()) + 1);
            System.out.println("Brewed 1 liter of " + cooker.getType() + " brandy!");
        }
    }
}
