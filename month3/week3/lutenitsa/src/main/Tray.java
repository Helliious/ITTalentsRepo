package main;

import java.util.List;

public class Tray extends PepperBaker {
    private final PepperBaker pepperBaker;
    protected int lutenitsaQuantity;

    Tray(Sack sack, PepperBaker pepperBaker, String name) {
        super(sack, name);
        this.pepperBaker = pepperBaker;
        lutenitsaQuantity = 0;
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
            pepperBaker.supply(product);
        }
        super.deliverDeficitProducts();
    }

    protected synchronized void deliver() {
        while (hasDeficitProducts()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        deliverLutenitsa();
        if (hasDeficitProducts()) {
            notifyAll();
        }
    }

    private void deliverLutenitsa() {
        products.put(ProductName.TOMATO, products.get(ProductName.TOMATO) - 2);
        products.put(ProductName.EGGPLANT, products.get(ProductName.EGGPLANT) - 1);
        products.put(ProductName.PEPPER, products.get(ProductName.PEPPER) - 3);
        System.out.println(Thread.currentThread().getName() + " bought 1 lutenitsa!");
    }

    @Override
    protected int minQuantity() {
        return 3;
    }

    @Override
    protected int startQuantity() {
        return 0;
    }

    @Override
    protected int deliverQuantity() {
        return 50;
    }

    @Override
    protected int supplyQuantity() {
        return 10;
    }
}
