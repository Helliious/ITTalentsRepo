package main;

public class Vehicle extends Thread {
    private GasStation gasStation;
    private boolean isCharged;
    private boolean isServiced;

    Vehicle(GasStation gasStation, String name) {
        super(name);
        this.gasStation = gasStation;
        isCharged = false;
        isServiced = false;
    }

    @Override
    public void run() {
        gasStation.loadVehicle(this);
    }

    public boolean isCharged() {
        return isCharged;
    }

    public boolean isServiced() {
        return isServiced;
    }

    public void setCharged() {
        isCharged = true;
    }

    public void setServiced() {
        isServiced = true;
    }
}
