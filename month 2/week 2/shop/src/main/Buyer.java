package main;

import main.products.Product;
import main.products.ProductSoldByAmount;
import main.products.ProductSoldByNumber;

public class Buyer {
    private final Shop shop;
    private final Product[] shopCart;
    private double amountOfMoney;
    private int maxCountOfItems;
    private int freeCartSlotIdx;

    Buyer(Shop shop, double amountOfMoney, int maxCountOfItems) {
        this.shop = shop;
        if (amountOfMoney > 0) {
            this.amountOfMoney = amountOfMoney;
        }
        if (maxCountOfItems > 0) {
            this.maxCountOfItems = maxCountOfItems;
        }
        shopCart = new Product[maxCountOfItems];
        freeCartSlotIdx = 0;
    }

    //FUTURE Functionality
    void showBasket() {
        for (int i = 0; i < shopCart.length; i++) {
            if (shopCart[i] != null) {
                shopCart[i].showProduct();
            }
            System.out.println();
        }
    }

    void buyProduct(Product product, double amount) {
        boolean isPresent = false;
        int productIdx = 0;

        System.out.println("Bought " +
                amount +
                " amount of " +
                product.getName());
        shop.reduceProduct(product, amount);
        for (int i = 0; i < shopCart.length; i++) {
            if (shopCart[i] != null) {
                if (shopCart[i].getName().equals(product.getName())) {
                    isPresent = true;
                    productIdx = i;
                    break;
                }
            }
        }

        if (isPresent) {
            shopCart[productIdx].addQuantity(amount);
        } else if (freeCartSlotIdx < maxCountOfItems) {
            if (product instanceof ProductSoldByAmount) {
                shopCart[freeCartSlotIdx] = new ProductSoldByAmount(
                        product.getName(),
                        product.getPrice(),
                        amount);
            }
            if (product instanceof ProductSoldByNumber) {
                shopCart[freeCartSlotIdx] = new ProductSoldByNumber(
                        product.getName(),
                        product.getPrice(),
                        (int)amount);
            }
            freeCartSlotIdx++;
        }
    }

    void returnProduct(Product product, double amount) {
        System.out.println("Returned " +
                amount +
                " amount of " +
                product.getName());
        shop.addProduct(product, amount);
        int productIdx = findProduct(product);
        shopCart[productIdx].reduceQuantity(amount);
    }

    int findProduct(Product product) {
        for (int i = 0; i < shopCart.length; i++) {
            if (shopCart[i].getName().equals(product.getName())) {
                return i;
            }
        }
        return -1;
    }
    
    void cashOut() {
        double money = 0;
        for (int i = 0; i < shopCart.length; i++) {
            if (shopCart[i] != null) {
                money += shopCart[i].calcPrice();
                money = Math.round(money * 100.0) / 100.0;
            }
        }

        if (money <= amountOfMoney) {
            amountOfMoney -= money;
            shop.transaction(money);
            System.out.println("Money left in your account: " + amountOfMoney);
            System.out.println("Bye bye, thanks for buying from " +
                    shop.getName());
        } else {
            System.out.println("Dude... not enough money YOU have," +
                    " work YOU should!");
        }
    }
}
