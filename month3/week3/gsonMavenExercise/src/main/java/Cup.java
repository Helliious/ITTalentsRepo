public class Cup {
    private String color;
    private int capacity;
    private Drink drink;

    public Cup(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.drink = new Drink(true, "Tea");
    }
}
