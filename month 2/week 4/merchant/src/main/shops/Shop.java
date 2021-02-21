package main.shops;

import main.Product;
import main.constants.Constants;
import main.util.Randomizator;

import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Shop {
    private final String address;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final int shopSize;
    private final ArrayList<Product> products;

    Shop(int shopSize) {
        this.address = Constants.ADDRESSES[Randomizator.randomNum(
                0,
                Constants.ADDRESSES.length
        )];
        this.startTime = LocalTime.of(10, 0);
        this.endTime = startTime.plusHours(8);
        this.shopSize = shopSize;
        this.products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public abstract int getTax();
    public abstract void stockUp(ArrayList<Product> products);
}
