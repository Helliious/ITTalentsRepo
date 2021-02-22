package main.suppliers;

import main.Product;
import main.constants.Constants;
import main.util.Randomizator;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Supplier {
    private String name;

    Supplier() {
        this.name = Constants.NAMES[Randomizator.randomNum(
                0,
                Constants.NAMES.length
        )];
    }

    public ArrayList<Product> generateProducts(double amountMoney) {
        ArrayList<Product> products = new ArrayList<>();
        while (amountMoney > 0) {
            Product product = new Product();
            products.add(product);
            amountMoney -= product.getPrice();
        }
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(name, supplier.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public abstract int getDiscount();
}
