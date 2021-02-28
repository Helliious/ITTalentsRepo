package main;

public class LutenitsaDemo {
    public static void main(String[] args) {
        Sack sack = new Sack("Sack");
        Supplier supplier = new Supplier(sack, "Supplier");
        supplier.start();
        PepperBaker pepperBaker = new PepperBaker(sack, "PepperBaker");
        new Thread(pepperBaker).start();
        Tray tray = new Tray(sack, pepperBaker, "Tray");
        new Thread(tray).start();

        Client client1 = new Client(tray);
        Client client2 = new Client(tray);
        Client client3 = new Client(tray);

        client1.start();
        client2.start();
        client3.start();

        Thread data = new Thread(() -> {
            while (true) {
                sack.showAvailability();
                pepperBaker.showAvailability();
                tray.showAvailability();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        data.setDaemon(true);
        data.start();
    }
}
