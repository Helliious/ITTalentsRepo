package main.instruments;

public abstract class MusicalInstrument {
    private final String name;
    private final String type;
    private double price;
    private int quantity;

    MusicalInstrument(String name, String type, double price, int quantity) {
        this.name = name;
        this.type = type;
        if (price > 0) {
            this.price = price;
        }
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public void addQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity += quantity;
        }
    }

    public void reduceQuantity(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
        } else {
            System.out.println("Not enough amount of instrument: " + name);
        }
    }

    public void showInstrument() {
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
}
