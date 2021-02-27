package main;

import java.util.HashMap;
import java.util.Map;

public class Sack {
    enum ProductName {
        POTATO, MINCEMEAT, EGG, YOGURT, ONION
    }

    protected final HashMap<ProductName, Integer> products;
    protected final String name;

    Sack(String name) {
        this.name = name;
        products = new HashMap<>();
        products.put(ProductName.POTATO, startingQuantity());
        products.put(ProductName.MINCEMEAT, startingQuantity());
        products.put(ProductName.EGG, startingQuantity());
        products.put(ProductName.YOGURT, startingQuantity());
        products.put(ProductName.ONION, startingQuantity());
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
        supplyDeficitProducts();
        notifyAll();
    }

    protected synchronized void deliver(ProductName productName) {
        while (isDeficitProduct(productName)) {
            try {
                System.out.println(Thread.currentThread().getName() + " - " + productName + " is deficit, I wait!");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int soldAmount = deliverProduct(productName);
        System.out.println(Thread.currentThread().getName() + " - get " + soldAmount + " " + productName);
        if (isDeficitProduct(productName)) {
            notifyAll();
        }
    }

    protected boolean hasDeficitProducts() {
        for (Integer amount : products.values()) {
            if (amount < minQuantity()) {
                return true;
            }
        }
        return false;
    }

    protected void supplyDeficitProducts() {
        for (Map.Entry<ProductName, Integer> product : products.entrySet()) {
            if (product.getValue() < minQuantity()) {
                products.put(product.getKey(), product.getValue() + supplyQuantity());
            }
        }
    }

    protected boolean isDeficitProduct(ProductName productName) {
        for (Map.Entry<ProductName, Integer> product : products.entrySet()) {
            if (product.getKey() == productName && product.getValue() < minQuantity()) {
                return true;
            }
        }
        return false;
    }

    protected int deliverProduct(ProductName productName) {
        int soldAmount = deliverQuantity();
        for (Map.Entry<ProductName, Integer> product : products.entrySet()) {
            if (product.getKey() == productName) {
                products.put(product.getKey(), product.getValue() - soldAmount);
            }
        }
        return soldAmount;
    }

    protected void showAvailability() {
        System.out.println("-----------------------" + name + "-----------------------");
        for (Map.Entry<ProductName, Integer> product : products.entrySet()) {
            System.out.println(product.getKey() + " - " + product.getValue());
        }
        System.out.println("----------------------------------------------------------");
    }

    protected int startingQuantity() {
        return 30;
    }

    protected int minQuantity() {
        return 5;
    }

    protected int supplyQuantity() {
        return 25;
    }

    protected int deliverQuantity() {
        return 15;
    }
}
