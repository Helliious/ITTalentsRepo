package main;

import main.products.Product;

public class Shop {
    private final String name;
    private final String address;
    private double moneyInCashDesk;
    private final Product[] products;

    Shop(String name,
         String address,
         double moneyInCashDesk,
         Product[] products) {
        this.name = name;
        this.address = address;
        if (moneyInCashDesk >= 0) {
            this.moneyInCashDesk = moneyInCashDesk;
        }
        this.products = products;
    }

    public String getName() {
        return name;
    }

    void showShopStats() {
        System.out.println("Name " + name);
        System.out.println("Address: " + address + "\n");
        System.out.println("Money in cash deck: " + moneyInCashDesk);
        showProductsInStock();
    }

    void showProductsInStock() {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                products[i].showProduct();
                System.out.println();
            }
        }
    }

    void addProduct(Product product, double amount) {
        int productIdx = 0;
        productIdx = findProductIdx(product);
        products[productIdx].addQuantity(amount);
    }

    void reduceProduct(Product product, double amount) {
        int productIdx = 0;
        productIdx = findProductIdx(product);
        products[productIdx].reduceQuantity(amount);
    }

    int findProductIdx(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                if (products[i].getName().equals(product.getName())) {
                    return i;
                }
            }
        }
        return -1;
    }

    void transaction(double amount) {
        if (amount > 0) {
            moneyInCashDesk += amount;
        }
    }
}
