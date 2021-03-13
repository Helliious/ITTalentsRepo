package main;

import util.Randomizator;

import java.util.LinkedList;

public class Ship extends Thread {
    private boolean isServiced;
    private final Harbour harbour;
    private final LinkedList<Package> packages;

    Ship(Harbour harbour, String name) {
        super(name);
        isServiced = false;
        this.harbour = harbour;
        packages = new LinkedList<>();
        int packagesCount = Randomizator.getRandomNum(1, 5);
        for (int i = 0; i < packagesCount; i++) {
            packages.add(new Package());
        }
    }

    public boolean isServiced() {
        return isServiced;
    }

    public void setServiced() {
        isServiced = true;
    }

    public LinkedList<Package> unloadPackages() {
        return packages;
    }

    public int getPackagesAmount() {
        return packages.size();
    }

    @Override
    public void run() {
        harbour.serviceShip(this);
    }
}
