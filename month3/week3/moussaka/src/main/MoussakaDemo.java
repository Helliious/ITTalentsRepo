package main;

public class MoussakaDemo {
    public static void main(String[] args) {
        Sack sack = new Sack("Sack");
        Supplier supplier = new Supplier(sack, "Supplier");
        supplier.start();

        Moussaka moussaka = new Moussaka(sack, "Moussaka");
        new Thread(moussaka, "MoussakaThread").start();

        Client client1 = new Client(moussaka, "Client-1");
        Client client2 = new Client(moussaka, "Client-2");
        Client client3 = new Client(moussaka, "Client-3");

        client1.start();
        client2.start();
        client3.start();

        Thread data = new Thread(() -> {
            while (true) {
                sack.showAvailability();
                moussaka.showAvailability();
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
