package main;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    protected final String name;
    enum ProductType {
        FRUITS, VEGETABLES, MEATS
    }

    enum ProductName {
        BANANA, ORANGE, APPLE, POTATO, EGGPLANT, CUCUMBER,
        PORK, BEEF, CHICKEN
    }

    protected HashMap<ProductType, HashMap<ProductName, Integer>> products;

    Warehouse(String name) {
        this.name = name;
        this.products = new HashMap<>();
        products.put(ProductType.FRUITS, new HashMap<>());
        products.get(ProductType.FRUITS).put(ProductName.BANANA, startingQuantity());
        products.get(ProductType.FRUITS).put(ProductName.ORANGE, startingQuantity());
        products.get(ProductType.FRUITS).put(ProductName.APPLE, startingQuantity());
        products.put(ProductType.VEGETABLES, new HashMap<>());
        products.get(ProductType.VEGETABLES).put(ProductName.POTATO, startingQuantity());
        products.get(ProductType.VEGETABLES).put(ProductName.EGGPLANT, startingQuantity());
        products.get(ProductType.VEGETABLES).put(ProductName.CUCUMBER, startingQuantity());
        products.put(ProductType.MEATS, new HashMap<>());
        products.get(ProductType.MEATS).put(ProductName.PORK, startingQuantity());
        products.get(ProductType.MEATS).put(ProductName.BEEF, startingQuantity());
        products.get(ProductType.MEATS).put(ProductName.CHICKEN, startingQuantity());
    }

    protected synchronized void fill() {
        while (!hasDeficitProducts()) {
            System.out.println(Thread.currentThread().getName() + " - no deficit products, I wait!");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " supply deficit products!");
        supplyDeficitProducts();
        notifyAll();
    }

    protected synchronized void supply(ProductName productName) {
        while (isDeficit(productName)) {
            System.out.println(Thread.currentThread().getName() + " - " + productName + " is deficit, I wait!");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int sold = deliver(productName);
        System.out.println(Thread.currentThread().getName() + " - get " + sold + " " + productName);
        if (isDeficit(productName)) {
            notifyAll();
        }
    }

    protected boolean hasDeficitProducts() {
        for (HashMap<ProductName, Integer> deficits : products.values()) {
            for (Integer amount : deficits.values()) {
                if (amount < getMinimumQuantity()) {
                    return true;
                }
            }
        }
        return false;
    }

    protected void supplyDeficitProducts() {
        for (HashMap<ProductName, Integer> deficits : products.values()) {
            for (Map.Entry<ProductName, Integer> product : deficits.entrySet()) {
                if (product.getValue() < getMinimumQuantity()) {
                    deficits.put(product.getKey(), product.getValue() + supplyQuantity());
                }
            }
        }
    }

    protected boolean isDeficit(ProductName productName) {
        for (HashMap<ProductName, Integer> deficits : products.values()) {
            for (Map.Entry<ProductName, Integer> product : deficits.entrySet()) {
                if (product.getKey() == productName && product.getValue() < getMinimumQuantity()) {
                    return true;
                }
            }
        }
        return false;
    }

    protected int deliver(ProductName productName) {
        int sold = deliverQuantity();
        for (HashMap<ProductName, Integer> deficits : products.values()) {
            for (Map.Entry<ProductName, Integer> product : deficits.entrySet()) {
                if (product.getKey() == productName) {
                    deficits.put(product.getKey(), product.getValue() - sold);
                }
            }
        }
        return sold;
    }

    protected int getMinimumQuantity() {
        return 10;
    }

    protected int supplyQuantity() {
        return 25;
    }

    protected int deliverQuantity() {
        return 15;
    }

    protected int startingQuantity() {
        return 50;
    }

    public void showInventory() {
        System.out.println("------------------" + name + "--------------------");
        for(HashMap<ProductName, Integer> p : products.values()){
            for(Map.Entry<ProductName, Integer> e : p.entrySet()){
                System.out.println(e.getKey() + " - " + e.getValue());
            }
        }
        System.out.println("--------------------------------------------------");
    }
}
