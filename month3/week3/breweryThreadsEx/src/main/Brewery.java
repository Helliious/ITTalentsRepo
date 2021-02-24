package main;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Brewery {
    private static final int CALDRONS_COUNT = 5;
    private final BlockingQueue<Caldron> caldrons;

    Brewery() {
        caldrons = new ArrayBlockingQueue<>(CALDRONS_COUNT);
    }

    public void addCaldron(Caldron caldron) {
        try {
            caldrons.put(caldron);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Caldron getNonFullCaldron() {
        for (Caldron c : caldrons) {
            if (!c.isFull()) {
                return c;
            }
        }
        return null;
    }

    public Caldron getFullCaldron() {
        for (Caldron c : caldrons) {
            if (c.isFull()) {
                return c;
            }
        }
        return null;
    }
}
