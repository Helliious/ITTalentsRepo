package main.bankProducts;

import main.constants.Constants;

import java.util.Objects;

public abstract class BankProduct {
    private final String name;
    private final int productPeriod;
    private double stock;

    BankProduct(String name, int productPeriod, double stock) {
        this.name = name;
        if (productPeriod >= Constants.MIN_PERIOD && productPeriod <= Constants.MAX_PERIOD) {
            this.productPeriod = productPeriod;
        } else {
            this.productPeriod = 1;
        }
        this.stock = stock;
    }

    public void evaluateStock(double amount) {
        stock += amount;
    }

    public double calcInterest() {
        double monthlyPercent = getAnnualInterestPercent() / 12;
        return (stock * productPeriod * monthlyPercent) / 100;
    }

    public double getAnnualPayment() {
        return stock / productPeriod;
    }

    public double getStock() {
        return stock;
    }

    public void reduceMoney(double amount) {
        if (amount > stock) {
            stock = 0;
        } else {
            stock -= amount;
        }
    }

    public abstract double getAnnualInterestPercent();
    public abstract BankProductType getType();

    public void showProduct() {
        System.out.println("==========" + name + "==========");
        System.out.println("Period: " + productPeriod);
        System.out.println("Stock: " + stock);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankProduct that = (BankProduct) o;
        return productPeriod == that.productPeriod && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, productPeriod);
    }
}
