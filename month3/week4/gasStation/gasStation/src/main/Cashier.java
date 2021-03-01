package main;

public class Cashier extends Thread {
    private GasStation gasStation;

    Cashier(GasStation gasStation, String name) {
        super(name);
        this.gasStation = gasStation;
    }

    @Override
    public void run() {
        while (true) {
            gasStation.serviceCustomer();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " serviced customer!");
        }
    }
}
