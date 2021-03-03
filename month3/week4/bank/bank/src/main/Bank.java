package main;

import main.bankProducts.*;
import main.clients.Client;
import main.constants.Constants;
import main.util.Randomizator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Bank {
    private final String name;
    private final String address;
    private final HashMap<Client, HashMap<BankProductType, ArrayList<BankProduct>>> bankProducts;
    private double moneyInStock;
    private double reserve;

    Bank(String name, String address) {
        this.name = name;
        this.address = address;
        bankProducts = new HashMap<>();
        moneyInStock = Constants.BANK_STARTING_MONEY;
        reserve = (moneyInStock * 10) / 100;
        reserve = Math.round(reserve * 100.0) / 100.0;
    }

    public Deposit takeDeposit(double amount, Client client) {
        Deposit deposit = Randomizator.randomNumRange(0, 2) == 0 ? new ShortDeposit(amount) : new LongDeposit(amount);
        checkBankProduct(client, deposit);
        bankProducts.get(client).get(deposit.getType()).add(deposit);
        addMoney(amount);
        return deposit;
    }

    public void payAnnualInterest() {
        double interest;
        for (Map.Entry<Client, HashMap<BankProductType, ArrayList<BankProduct>>> clientBankProducts : bankProducts.entrySet()) {
            ArrayList<BankProduct> deposits = clientBankProducts.getValue().get(BankProductType.DEPOSIT);
            for (BankProduct deposit : deposits) {
                interest = deposit.calcInterest();
                addMoney(interest);
                deposit.evaluateStock(interest);
            }
        }
    }

    public Credit grantCredit(double amount, int period, Client client) {
        if (isAbleToGrantCredit(amount)) {
            double currAnnualPayment = 0;
            Credit newCredit = Randomizator.randomNumRange(0, 2) == 0 ? new ConsumerCredit(period, amount) : new HomeCredit(period, amount);
            ArrayList<BankProduct> credits = bankProducts.get(client).get(BankProductType.CREDIT);
            if (credits != null) {
                for (BankProduct credit : credits) {
                    currAnnualPayment += credit.getAnnualPayment();
                }
            }
            if (currAnnualPayment <= client.getSalary() / 2) {
                checkBankProduct(client, newCredit);
                reduceMoney(amount);
                bankProducts.get(client).get(newCredit.getType()).add(newCredit);
                return newCredit;
            } else {
                System.out.println("You have too much credits! Bank will not give you another one!");
            }
        } else {
            System.out.println("Bank doesn't have enough money at the moment, please come later!");
        }
        return null;
    }

    public void receiveCreditPayment(BankProduct product, Client client) {
        for (BankProduct bankProduct : bankProducts.get(client).get(product.getType())) {
            if (bankProduct == product) {
                addMoney(bankProduct.getAnnualPayment());
            }
        }
    }

    private void checkBankProduct(Client client, BankProduct product) {
        if (!bankProducts.containsKey(client)) {
            bankProducts.put(client, new HashMap<>());
        }
        if (!bankProducts.get(client).containsKey(product.getType())) {
            bankProducts.get(client).put(product.getType(), new ArrayList<>());
        }
    }

    private boolean isAbleToGrantCredit(double amount) {
        return amount <= moneyInStock - reserve;
    }

    private void reduceMoney(double amount) {
        moneyInStock -= amount;
        reserve = (moneyInStock * 10) / 100;
        reserve = Math.round(reserve * 100.0) / 100.0;
    }

    private void addMoney(double amount) {
        moneyInStock += amount;
        reserve = (moneyInStock * 10) / 100;
        reserve = Math.round(reserve * 100.0) / 100.0;
    }

    public void showAvailability() {
        System.out.println("===================" + name + "===================");
        System.out.println("Money availability: " + moneyInStock + "$");
        System.out.println("Reserve amount: " + reserve + "$");
        System.out.println("=========================================");
    }
}
