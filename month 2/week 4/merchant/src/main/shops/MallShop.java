package main.shops;

import main.Product;
import main.constants.Constants;
import main.util.Randomizator;

import java.util.ArrayList;

public class MallShop extends Shop implements ChainShop {
    MallShop() {
        super(Randomizator.randomNum(10, 101));
    }

    @Override
    public void stockUp(ArrayList<Product> products) {
        getProducts().addAll(products);
    }

    @Override
    public int getTax() {
        return Constants.MALL_TAX;
    }
}
