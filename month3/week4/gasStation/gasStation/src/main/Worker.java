package main;

public class Worker extends Thread {
    private final GasStation gasStation;

    Worker(GasStation gasStation, String name) {
        super(name);
        this.gasStation = gasStation;
    }

    @Override
    public void run() {
        while (true) {
            gasStation.loadFuel();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " loaded a car!");
        }
    }
}
