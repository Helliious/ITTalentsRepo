package main.merchants;

import main.Product;
import main.shops.ETShop;
import main.shops.Shop;
import main.suppliers.Retailer;
import main.suppliers.Supplier;
import main.util.Randomizator;

import java.util.ArrayList;

public class ET extends Merchant {
    private final ArrayList<Retailer> suppliers;
    private final ETShop shop;

    public ET(ArrayList<Retailer> suppliers, ETShop shop) {
        super();
        this.suppliers = suppliers;
        this.shop = shop;
    }

    @Override
    public void makeOrder() {
        double newProductsPrice = 0;
        ArrayList<Product> reloadProd = new ArrayList<>();
        reloadProd.addAll(getSupplier().generateProducts(getStartMoney() / 2));
        for (Product p : reloadProd) {
            newProductsPrice += p.getPrice();
        }
        ((Shop)shop).stockUp(reloadProd);
        reduceMoney(newProductsPrice);
    }

    @Override
    Supplier getSupplier() {
        int idx = Randomizator.randomNum(0, suppliers.size());
        return suppliers.get(idx);
    }

    @Override
    public void getTurnover() {
        double turnover = 0;
        int countOfSoldItems = Randomizator.randomNum(1, ((Shop)shop).getProducts().size());
        for (int i = 0; i < countOfSoldItems; i++) {
            int itemIdx = Randomizator.randomNum(0, ((Shop)shop).getProducts().size());
            double itemPrice = ((Shop)shop).getProducts().remove(itemIdx).getPrice();
            itemPrice += (itemPrice * 30) / 100;
            turnover += itemPrice;
        }
        addMoney(turnover);
    }

    @Override
    public void payTaxes() {
        reduceMoney(((Shop)shop).getTax());
    }
}
