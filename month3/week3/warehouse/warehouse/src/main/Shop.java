package main;

import java.util.*;

public class Shop extends Warehouse implements Runnable {
    private final Warehouse warehouse;

    Shop(Warehouse warehouse, String name) {
        super(name);
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        while (true) {
            this.fill();
        }
    }

    @Override
    protected void supplyDeficitProducts() {
        List<ProductName> deficits = getDeficitProducts();
        System.out.println("Deficit products in " + name + " are " + deficits);
        for (ProductName name : deficits) {
            warehouse.supply(name);
        }
        super.supplyDeficitProducts();
    }

    private List<ProductName> getDeficitProducts() {
        List<ProductName> deficitProducts = new ArrayList<>();
        for (HashMap<ProductName, Integer> deficits : products.values()) {
            for (Map.Entry<ProductName, Integer> product : deficits.entrySet()) {
                if (product.getValue() < getMinimumQuantity()) {
                    deficitProducts.add(product.getKey());
                }
            }
        }
        return deficitProducts;
    }

    @Override
    protected int startingQuantity() {
        return 0;
    }

    @Override
    protected int getMinimumQuantity() {
        return 5;
    }

    @Override
    protected int deliverQuantity() {
        return new Random().nextInt(4) + 1;
    }

    @Override
    protected int supplyQuantity() {
        return 15;
    }
}
