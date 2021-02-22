package main.products;

public class ProductSoldByAmount extends Product {
    private double kg;

    public ProductSoldByAmount(String name, double price, double kg) {
        super(name, price);
        if (kg > 0) {
            this.kg = kg;
        }
    }

    @Override
    public void showProduct() {
        showStats();
        System.out.println("Quantity in stock: " + this.kg + "kg");
    }

    @Override
    public void reduceQuantity(double amount) {
        if (kg >= amount) {
            kg -= amount;
        } else {
            System.out.println("Not enough amount left in stock!");
        }
    }

    @Override
    public double calcPrice() {
        double priceByGram = getPrice() / 1000;
        double priceToPay = priceByGram * (kg * 1000);
        return Math.round(priceToPay * 100.0) / 100.0;
    }

    @Override
    public void addQuantity(double amount) {
        if (amount > 0) {
            kg += amount;
        }
    }
}
