package main;

import main.products.ProductSoldByNumber;
import main.products.ProductSoldByAmount;
import main.products.Product;

public class ShopDemo {
    static final int BASKET_SIZE = 5;
    public static void main(String[] args) {
        boolean isShopping = true;
        Product meat = new ProductSoldByAmount(
                "Pork steak",
                2.25,
                15.5);
        Product fish = new ProductSoldByAmount(
                "Salmon",
                19.20,
                10);
        Product cheese = new ProductSoldByAmount(
                "Cow cheese",
                5.20,
                35.50);
        Product beer = new ProductSoldByNumber(
                "Stolichno",
                3.20,
                15);
        Product chips = new ProductSoldByNumber(
                "Ruffles",
                2.20,
                25);
        Product book = new ProductSoldByNumber(
                "Cosmopolitan",
                2.90,
                5);

        Product[] products = new Product[6];
        products[0] = meat;
        products[1] = fish;
        products[2] = cheese;
        products[3] = beer;
        products[4] = chips;
        products[5] = book;

        Shop shop = new Shop(
                "Slavqnka",
                "Bul. Geo Milev",
                1500,
                products);

        Buyer pesho = new Buyer(
                    shop,
                100,
                BASKET_SIZE);

        shop.showShopStats();
        System.out.println("====================================");
        pesho.buyProduct(meat, 1.5);
        pesho.buyProduct(fish, 2);
        pesho.buyProduct(beer, 5);
        pesho.buyProduct(chips, 1);
        pesho.returnProduct(chips, 1);
        System.out.println("====================================");
        pesho.cashOut();
        System.out.println("AFTER MARKET");
        shop.showShopStats();
    }
}
