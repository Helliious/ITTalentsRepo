package main;

import util.Randomizator;

import java.util.ArrayList;

public class Distributor extends Thread {
    private final Harbour harbour;

    Distributor(Harbour harbour, String name) {
        super(name);
        this.harbour = harbour;
    }

    @Override
    public void run() {
        while (true) {
            harbour.unloadWarehouse();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
