package main.merchants;

import main.Product;
import main.suppliers.Retailer;
import main.suppliers.Supplier;
import main.util.Randomizator;

import java.util.ArrayList;

public class Ambulant extends Merchant {
    private final ArrayList<Product> products;
    private final Retailer supplier;

    Ambulant(Retailer supplier) {
        super();
        this.products = new ArrayList<>();
        this.supplier = supplier;
    }

    @Override
    public void makeOrder() {
        double newProductsPrice = 0;
        ArrayList<Product> reloadProd = new ArrayList<>();
        reloadProd.addAll(getSupplier().generateProducts(getStartMoney() / 2));
        for (Product p : reloadProd) {
            newProductsPrice += p.getPrice();
        }
        reduceMoney(newProductsPrice);
    }

    @Override
    Supplier getSupplier() {
        return supplier;
    }

    @Override
    public void getTurnover() {
        double turnover = 0;
        int countOfSoldItems = Randomizator.randomNum(1, products.size());
        for (int i = 0; i < countOfSoldItems; i++) {
            int itemIdx = Randomizator.randomNum(0, products.size());
            double itemPrice = products.remove(itemIdx).getPrice();
            itemPrice += (itemPrice * 30) / 100;
            turnover += itemPrice;
        }
        addMoney(turnover);
    }

    @Override
    public void payTaxes() {
        reduceMoney(0);
    }
}
