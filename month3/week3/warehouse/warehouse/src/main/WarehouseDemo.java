package main;

public class WarehouseDemo {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse("Warehouse");
        Supplier supplier = new Supplier(warehouse);
        supplier.start();
        Shop shop1 = new Shop(warehouse, "Shop-1");
        Shop shop2 = new Shop(warehouse, "Shop-2");
        Shop shop3 = new Shop(warehouse, "Shop-3");

        new Thread(shop1, "Shop 1").start();
        new Thread(shop2, "Shop 2").start();
        new Thread(shop3, "Shop 3").start();

        Client client1 = new Client(shop1, "Client-1");
        Client client2 = new Client(shop1, "Client-2");
        Client client3 = new Client(shop1, "Client-3");
        Client client4 = new Client(shop2, "Client-4");
        Client client5 = new Client(shop2, "Client-5");
        Client client6 = new Client(shop2, "Client-6");
        Client client7 = new Client(shop3, "Client-7");
        Client client8 = new Client(shop3, "Client-8");
        Client client9 = new Client(shop3, "Client-9");

        client1.start();
        client2.start();
        client3.start();
        client4.start();
        client5.start();
        client6.start();
        client7.start();
        client8.start();
        client9.start();

        Thread data = new Thread(() -> {
            while (true){
                warehouse.showInventory();
                shop1.showInventory();
                shop2.showInventory();
                shop3.showInventory();
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
