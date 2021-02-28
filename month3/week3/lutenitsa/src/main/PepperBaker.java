package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PepperBaker extends Sack implements Runnable {
    private final Sack sack;

    PepperBaker(Sack sack, String name) {
        super(name);
        this.sack = sack;
    }

    @Override
    public void run() {
        while (true) {
            this.fill();
        }
    }

    @Override
    protected void deliverDeficitProducts() {
        List<ProductName> deficits = getDeficitProducts();
        System.out.println("Deficit products in " + name + " are " + deficits);
        for (ProductName product : deficits) {
            sack.supply(product);
        }
        super.deliverDeficitProducts();
    }

    protected List<ProductName> getDeficitProducts() {
        List<ProductName> deficits = new ArrayList<>();
        for (Map.Entry<ProductName, Integer> product : products.entrySet()) {
            if (product.getValue() < minQuantity()) {
                deficits.add(product.getKey());
            }
        }
        return deficits;
    }

    @Override
    protected int minQuantity() {
        return 5;
    }

    @Override
    protected int startQuantity() {
        return 0;
    }

    @Override
    protected int deliverQuantity() {
        return 55;
    }

    @Override
    protected int supplyQuantity() {
        return 50;
    }
}
