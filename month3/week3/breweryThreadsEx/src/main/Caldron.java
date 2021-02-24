package main;

public class Caldron {
    private static final int MAX_CAPACITY = 10;
    private FruitType fruitType;
    private int amount;
    private volatile boolean isFull;

    Caldron() {
        amount = 0;
        isFull = false;
    }

    public boolean isFull() {
        return isFull;
    }

    public synchronized void fill() {
        while (isFull) {
            try {
                System.out.println("Filled the caldron gonna wait!");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        amount++;
        System.out.println("Gathered 1kg of PLUM!");
        if (amount == MAX_CAPACITY) {
            System.out.println("Waking up brewers!");
            isFull = true;
            notifyAll();
        }
    }

    public synchronized void brew() {
        while (!isFull) {
            try {
                System.out.println("Brewed everything gonna wait!");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (amount > 0) {
            amount--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Brewed 1 liter of brandy!");
        }
        isFull = false;
        System.out.println("Waking up gatherers!");
        notifyAll();
    }
}
