package main.shops;

import main.Product;
import main.constants.Constants;
import main.util.Randomizator;

import java.util.ArrayList;

public class MarketShop extends Shop implements ETShop {
    MarketShop() {
        super(Randomizator.randomNum(2, 11));
    }

    @Override
    public void stockUp(ArrayList<Product> products) {
        getProducts().addAll(products);
    }

    @Override
    public int getTax() {
        return Constants.SHOP_TAX;
    }
}
