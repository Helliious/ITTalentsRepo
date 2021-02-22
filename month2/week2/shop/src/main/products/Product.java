package main.products;

public abstract class Product {
    private final String name;
    private double price;

    Product(String name, double price) {
        this.name = name;
        if (price > 0) {
            this.price = price;
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    void showStats() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }

    public abstract void showProduct();
    public abstract void addQuantity(double amount);
    public abstract void reduceQuantity(double amount);
    public abstract double calcPrice();
}
