package main;

import util.Randomizator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Harbour {
    private final ArrayList<Queue<Ship>> docks;
    private final ArrayList<Warehouse> warehouses;

    Harbour() {
        docks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            docks.add(new LinkedList<>());
        }
        warehouses = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            warehouses.add(new Warehouse());
        }
    }

    protected synchronized void serviceShip(Ship ship) {
        int dockIdx = Randomizator.getRandomNum(0, 5);
        docks.get(dockIdx).offer(ship);
        if (docks.get(dockIdx).size() == 1) {
            notifyAll();
        }

        System.out.println(Thread.currentThread().getName() + " waits for unload!");
        while (!ship.isServiced()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        docks.get(dockIdx).remove(ship);
        System.out.println(Thread.currentThread().getName() + " unloaded and leaving!");
        if (!docks.get(dockIdx).isEmpty()) {
            notifyAll();
        }
    }

    protected synchronized int unloadShip() {
        while (!hasNonEmptyDocks()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Queue<Ship> dock = getDock();
        assert dock != null;
        Ship ship = dock.peek();
        assert ship != null;
        LinkedList<Package> packages = ship.unloadPackages();
        if (Randomizator.getRandomNum(0, 2) == 0) {
            warehouses.get(0).addPackages(packages);
        } else {
            warehouses.get(1).addPackages(packages);
        }
        ship.setServiced();
        notifyAll();
        return ship.getPackagesAmount();
    }

    private boolean hasNonEmptyDocks() {
        for (Queue<Ship> dock : docks) {
            if (!dock.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private Queue<Ship> getDock() {
        for (Queue<Ship> dock : docks) {
            if (!dock.isEmpty()) {
                return dock;
            }
        }
        return null;
    }

    protected synchronized void unloadWarehouse() {
        while (!hasNonEmptyWarehouse()) {
            try {
                System.out.println(Thread.currentThread().getName() + " cleared warehouses, waiting!");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        warehouses.get(Randomizator.getRandomNum(0, 2)).deliverPackage();
        System.out.println(Thread.currentThread().getName() + " delivered a package!");
        notifyAll();
    }

    private boolean hasNonEmptyWarehouse() {
        for (Warehouse warehouse : warehouses) {
            if (!warehouse.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
