package main;

import java.util.Random;

public class Client extends Thread {
    private Shop shop;

    Client(Shop shop, String name) {
        super(name);
        this.shop = shop;
    }

    @Override
    public void run() {
        while (true) {
            int rangeOfProducts = Warehouse.ProductName.values().length;
            int productIdx = new Random().nextInt(rangeOfProducts);
            Warehouse.ProductName randomProduct = Warehouse.ProductName.values()[productIdx];
            shop.supply(randomProduct);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
