package main;

public class Package {
    private static int id = 0;
    private final int packageId;

    Package() {
        packageId = id++;
    }

    public int getPackageId() {
        return packageId;
    }
}
