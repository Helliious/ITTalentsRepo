package main;

import main.constants.Constants;
import main.util.Randomizator;

public class Product {
    private final String name;
    private final double price;

    public Product() {
        this.name = Constants.PRODUCT_NAMES[Randomizator.randomNum(
                0,
                Constants.PRODUCT_NAMES.length
        )];
        this.price = Randomizator.randomNum(5, 16);
    }

    public double getPrice() {
        return price;
    }
}
