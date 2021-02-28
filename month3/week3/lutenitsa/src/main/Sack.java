package main;

import java.util.HashMap;
import java.util.Map;

public class Sack {
    enum ProductName {
        PEPPER, EGGPLANT, TOMATO
    }

    protected HashMap<ProductName, Integer> products;
    protected final String name;

    Sack(String name) {
        this.name = name;
        products = new HashMap<>();
        products.put(ProductName.PEPPER, startQuantity());
        products.put(ProductName.EGGPLANT, startQuantity());
        products.put(ProductName.TOMATO, startQuantity());
    }

    protected synchronized void fill() {
        while (!hasDeficitProducts()) {
            try {
                System.out.println(Thread.currentThread().getName() + " - no deficit products, I wait!");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " supply deficit products!");
        deliverDeficitProducts();
        notifyAll();
    }

    protected synchronized void supply(ProductName productName) {
        while (isDeficit(productName)) {
            try {
                System.out.println(Thread.currentThread().getName() + " - " + productName + " is deficit, I wait!");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int soldAmount = deliver(productName);
        System.out.println(Thread.currentThread().getName() + " - get " + soldAmount + " " + productName);
        if (isDeficit(productName)) {
            notifyAll();
        }
    }

    private int deliver(ProductName productName) {
        int deliverAmount = supplyQuantity();
        for (Map.Entry<ProductName, Integer> product : products.entrySet()) {
            if (product.getKey() == productName) {
                products.put(product.getKey(), products.get(product.getKey()) - deliverAmount);
            }
        }
        return deliverAmount;
    }

    private boolean isDeficit(ProductName productName) {
        for (Map.Entry<ProductName, Integer> product : products.entrySet()) {
            if (product.getKey() == productName && product.getValue() < minQuantity()) {
                return true;
            }
        }
        return false;
    }

    protected void deliverDeficitProducts() {
        for (Map.Entry<ProductName, Integer> product : products.entrySet()) {
            if (product.getValue() < minQuantity()) {
                products.put(product.getKey(), products.get(product.getKey()) + deliverQuantity());
            }
        }
    }

    protected boolean hasDeficitProducts() {
        for (Map.Entry<ProductName, Integer> product : products.entrySet()) {
            if (product.getValue() < minQuantity()) {
                return true;
            }
        }
        return false;
    }

    void showAvailability() {
        System.out.println("-----------------------" + name + "-----------------------");
        for (Map.Entry<ProductName, Integer> product : products.entrySet()) {
            System.out.println(product.getKey() + " - " + product.getValue());
        }
        System.out.println("----------------------------------------------------------");
    }

    protected int startQuantity() {
        return 50;
    }

    protected int minQuantity() {
        return 10;
    }

    protected int deliverQuantity() {
        return 60;
    }

    protected int supplyQuantity() {
        return 55;
    }
}
