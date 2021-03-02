package main;

import java.util.LinkedList;

public class Warehouse {
    private final LinkedList<Package> packages;

    Warehouse() {
        packages = new LinkedList<>();
    }

    public void addPackages(LinkedList<Package> deliverPackages) {
        if (deliverPackages != null) {
            packages.addAll(deliverPackages);
        }
    }

    public boolean isEmpty() {
        return packages.isEmpty();
    }

    public void deliverPackage() {
        if (!isEmpty()) {
            packages.remove();
        }
    }
}
