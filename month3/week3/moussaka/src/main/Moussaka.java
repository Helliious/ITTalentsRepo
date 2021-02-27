package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Moussaka extends Sack implements Runnable {
    private final Sack sack;

    Moussaka(Sack sack, String name) {
        super(name);
        this.sack = sack;
    }

    @Override
    public void run() {
        while (true) {
            this.fill();
        }
    }

    protected synchronized void deliver() {
        while (hasDeficitProducts()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        deliverMoussaka();
        if (hasDeficitProducts()) {
            notifyAll();
        }
    }

    @Override
    protected void supplyDeficitProducts() {
        List<ProductName> deficitProducts = getDeficitProducts();
        System.out.println("Deficit products in " + name + " are " + deficitProducts);
        for (ProductName product : deficitProducts) {
            sack.deliver(product);
        }
        super.supplyDeficitProducts();
    }

    private List<ProductName> getDeficitProducts() {
        List<ProductName> deficitProducts = new ArrayList<>();
        for (Map.Entry<ProductName, Integer> product : products.entrySet()) {
            if (product.getValue() < minQuantity()) {
                deficitProducts.add(product.getKey());
            }
        }
        return deficitProducts;
    }

    private void deliverMoussaka() {
        products.put(ProductName.POTATO, products.get(ProductName.POTATO) - 1);
        products.put(ProductName.MINCEMEAT, products.get(ProductName.MINCEMEAT) - 1);
        products.put(ProductName.ONION, products.get(ProductName.ONION) - 1);
        products.put(ProductName.EGG, products.get(ProductName.EGG) - 1);
        products.put(ProductName.YOGURT, products.get(ProductName.YOGURT) - 1);
        System.out.println(Thread.currentThread().getName() + " bought 1 moussaka!");
    }

    @Override
    protected int minQuantity() {
        return 1;
    }

    @Override
    protected int startingQuantity() {
        return 0;
    }

    @Override
    protected int supplyQuantity() {
        return 10;
    }

    @Override
    protected int deliverQuantity() {
        return 1;
    }
}
