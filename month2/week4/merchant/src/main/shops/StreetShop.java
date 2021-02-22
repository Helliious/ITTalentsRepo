package main.shops;

import main.Product;
import main.constants.Constants;
import main.util.Randomizator;

import java.util.ArrayList;

public class StreetShop extends Shop implements ETShop, ChainShop {
    public StreetShop() {
        super(Randomizator.randomNum(4, 7));
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
