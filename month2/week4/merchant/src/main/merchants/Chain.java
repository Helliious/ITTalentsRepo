package main.merchants;

import main.Product;
import main.shops.ChainShop;
import main.shops.Shop;
import main.suppliers.Supplier;
import main.util.Randomizator;

import java.util.ArrayList;

public class Chain extends Merchant {
    private ArrayList<Supplier> suppliers;
    private ArrayList<ChainShop> shops;

    Chain(ArrayList<Supplier> suppliers,
          ArrayList<ChainShop> shops) {
        super();
        if (suppliers.size() <= 5) {
            this.suppliers = suppliers;
        }
        if (shops.size() <= 10) {
            this.shops = shops;
        }
    }

    @Override
    public void makeOrder() {
        double newProductsPrice = 0;
        Supplier supplier = getSupplier();
        ArrayList<Product> reloadProd = new ArrayList<>();
        reloadProd.addAll(supplier.generateProducts(getStartMoney() / 2));
        for (Product p : reloadProd) {
            newProductsPrice += p.getPrice();
        }
        newProductsPrice = (newProductsPrice * supplier.getDiscount()) / 100;
        int idx = Randomizator.randomNum(0, shops.size());
        ((Shop)(shops.get(idx))).stockUp(reloadProd);
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
        int shopIdx = Randomizator.randomNum(0, shops.size());
        int countOfSoldItems = Randomizator.randomNum(1, ((Shop)(shops.get(shopIdx))).getProducts().size());
        for (int i = 0; i < countOfSoldItems; i++) {
            int itemIdx = Randomizator.randomNum(0, ((Shop)(shops.get(shopIdx))).getProducts().size());
            double itemPrice = ((Shop)(shops.get(shopIdx))).getProducts().remove(itemIdx).getPrice();
            itemPrice += (itemPrice * 30) / 100;
            turnover += itemPrice;
        }
        addMoney(turnover);
    }

    @Override
    public void payTaxes() {
        for (ChainShop s : shops) {
            reduceMoney(((Shop)s).getTax());
        }
    }
}
