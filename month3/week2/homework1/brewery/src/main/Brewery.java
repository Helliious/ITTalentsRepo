package main;

import main.workers.Cooker;
import main.workers.FruitType;

import java.util.concurrent.BlockingQueue;

public class Brewery {
    private final BlockingQueue<Caldron> caldrons;

    Brewery(BlockingQueue<Caldron> caldrons) {
        this.caldrons = caldrons;
    }

    public Caldron getFullCaldron() {
        for (int i = 0; i < caldrons.size(); i++) {
            try {
                Caldron c = caldrons.take();
                if (c.isFull()) {
                    return c;
                } else {
                    caldrons.put(c);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Caldron getNonFullCaldron() {
        Caldron caldron;
        try {
            for (int i = 0; i < caldrons.size(); i++) {
                caldron = caldrons.take();
                if (!caldron.isFull()) {
                    return caldron;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void putCaldron(Caldron caldron) {
        try {
            caldrons.put(caldron);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void fillCaldron(FruitType fruitType) {
        Caldron caldron = getNonFullCaldron();
        while (caldron == null) {
            try {
                System.out.println(Thread.currentThread().getName() + "-Gatherer is waiting...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            caldron = getNonFullCaldron();
        }
        caldron.fill(fruitType);
        putCaldron(caldron);
        if (caldron.isFull()) {
            System.out.println(Thread.currentThread().getName() + " Waking up everyone!");
            notifyAll();
        }
    }

    public synchronized void brewCaldron(Cooker cooker) {
        Caldron caldron = getFullCaldron();
        while (caldron == null) {
            try {
                System.out.println(Thread.currentThread().getName() + "-Cooker is waiting...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            caldron = getFullCaldron();
        }
        caldron.brew(cooker);
        putCaldron(caldron);
        System.out.println(Thread.currentThread().getName() + " Gonna wake up everyone now !");
        notifyAll();
    }
}
