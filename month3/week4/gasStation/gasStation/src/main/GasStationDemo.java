package main;

public class GasStationDemo {
    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        Vehicle v1 = new Vehicle(gasStation, "Vehicle-1");
        Vehicle v2 = new Vehicle(gasStation, "Vehicle-2");
        Vehicle v3 = new Vehicle(gasStation, "Vehicle-3");
        Vehicle v4 = new Vehicle(gasStation, "Vehicle-4");
        Vehicle v5 = new Vehicle(gasStation, "Vehicle-5");
        Vehicle v6 = new Vehicle(gasStation, "Vehicle-6");
        Vehicle v7 = new Vehicle(gasStation, "Vehicle-7");
        Vehicle v8 = new Vehicle(gasStation, "Vehicle-8");
        Vehicle v9 = new Vehicle(gasStation, "Vehicle-9");
        Vehicle v10 = new Vehicle(gasStation, "Vehicle-10");
        v1.start();
        v2.start();
        v3.start();
        v4.start();
        v5.start();
        v6.start();
        v7.start();
        v8.start();
        v9.start();
        v10.start();

        Worker worker1 = new Worker(gasStation, "Worker-1");
        Worker worker2 = new Worker(gasStation, "Worker-2");
        worker1.start();
        worker2.start();

        Cashier cashier1 = new Cashier(gasStation, "Cashier-1");
        Cashier cashier2 = new Cashier(gasStation, "Cashier-2");
        cashier1.start();
        cashier2.start();
    }
}
