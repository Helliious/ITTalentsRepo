package main.products;

public class ProductSoldByNumber extends Product {
    private int quantity;

    public ProductSoldByNumber(String name, double price, int quantity) {
        super(name, price);
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    @Override
    public void showProduct() {
        showStats();
        System.out.println("Quantity in stock: " + this.quantity + " pieces");
    }

    @Override
    public void reduceQuantity(double amount) {
        if (amount % 1 == 0) {
            if (quantity >= amount) {
                quantity -= amount;
            } else {
                System.out.println("Not enough quantity left in stock!");
            }
        } else {
            System.out.println("Invalid input!");
        }
    }

    @Override
    public double calcPrice() {
        double priceToPay = getPrice() * quantity;
        return Math.round(priceToPay * 100.0) / 100.0;
    }

    @Override
    public void addQuantity(double amount) {
        if (amount > 0 && amount % 10 == 0) {
            quantity += amount;
        }
    }
}
