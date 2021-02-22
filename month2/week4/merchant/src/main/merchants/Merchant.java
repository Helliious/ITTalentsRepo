package main.merchants;

import main.constants.Constants;
import main.suppliers.Supplier;
import main.util.Randomizator;

public abstract class Merchant {
    private final String name;
    private final String address;
    private double startMoney;

    Merchant() {
        this.name = Constants.NAMES[Randomizator.randomNum(
                0,
                Constants.NAMES.length
        )];
        this.address = Constants.ADDRESSES[Randomizator.randomNum(
                0,
                Constants.ADDRESSES.length
        )];
        this.startMoney = Randomizator.randomNum(200, 300);
    }

    public double getStartMoney() {
        return startMoney;
    }

    void reduceMoney(double amount) {
        if (startMoney > amount) {
            startMoney -= amount;
        }
    }

    void addMoney(double amount) {
        if (amount > 0) {
            startMoney += amount;
        }
    }

    public abstract void makeOrder();
    abstract Supplier getSupplier();
    public abstract void getTurnover();
    public abstract void payTaxes();
}
