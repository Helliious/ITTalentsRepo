package main;

import main.clients.Client;


public class LibraryDemo {
    public static void main(String[] args) {
        Library library = new Library();
        Client client1 = new Client(library);
        Client client2 = new Client(library);
        Client client3 = new Client(library);

        client1.start();
        client2.start();
        client3.start();

        Thread data = new Thread(() -> {
            while (true) {
                library.showAvailability();
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
