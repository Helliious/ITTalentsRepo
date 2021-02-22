package main;

import main.merchants.ET;
import main.merchants.Merchant;
import main.shops.ETShop;
import main.shops.StreetShop;
import main.suppliers.Retailer;
import main.suppliers.Supplier;

import java.util.ArrayList;

public class MerchantDemo {
    public static void main(String[] args) {
        ArrayList<Retailer> suppliers = new ArrayList<>();
        ETShop shop = new StreetShop();
        suppliers.add(new Retailer());
        Merchant merchant = new ET(suppliers, shop);
        System.out.println("Start money: " + merchant.getStartMoney());
        merchant.payTaxes();
        System.out.println("Start money: " + merchant.getStartMoney());
    }
}
