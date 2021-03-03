package main.clients;

import main.Bank;
import main.bankProducts.Credit;
import main.bankProducts.Deposit;
import main.constants.Constants;
import main.util.Randomizator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class Client {
    private final String name;
    private final String address;
    private double pocketMoney;
    private final double salary;
    private final LinkedList<Deposit> deposits;
    private final ArrayList<Credit> credits;

    public Client() {
        this.name = Constants.NAMES[Randomizator.randomNumRange(
                0,
                Constants.NAMES.length
        )];
        this.address = Constants.ADDRESSES[Randomizator.randomNumRange(
                0,
                Constants.ADDRESSES.length
        )];
        this.salary = Randomizator.randomNumRange(Constants.MIN_SALARY, Constants.MAX_SALARY);
        this.pocketMoney += this.salary;
        this.deposits = new LinkedList<>();
        this.credits = new ArrayList<>();
    }

    public double getSalary() {
        return salary;
    }

    public double getPocketMoney() {
        return pocketMoney;
    }

    public void payDay() {
        pocketMoney += salary;
    }

    public void makeDeposit(double moneyAmount, Bank bank) {
        if (moneyAmount <= pocketMoney) {
            pocketMoney -= moneyAmount;
            deposits.add(bank.takeDeposit(moneyAmount, this));
        }
    }

    public void askForCredit(double moneyAmount, int period, Bank bank) {
        Credit credit = bank.grantCredit(moneyAmount, period, this);
        assert credit != null;
        credits.add(credit);
    }

    public void makeAnnualPayment(Bank bank) {
        double payment;
        for (int i = 0; i < credits.size(); i++) {
            payment = credits.get(i).getAnnualPayment();
            pocketMoney -= payment;
            credits.get(i).giveAnnualPayment();
            bank.receiveCreditPayment(credits.get(i), this);
        }
    }

    public void showClientInfo() {
        System.out.println("--------------------------------");
        System.out.println("Client: " + name);
        System.out.println("Address: " + address);
        System.out.println("Pocket money: " + pocketMoney);
        System.out.println("Salary: " + salary);
        System.out.println("Deposits:");
        for (int i = 0; i < deposits.size(); i++) {
            deposits.get(i).showProduct();
        }
        System.out.println("Credits:");
        for (int i = 0; i < credits.size(); i++) {
            credits.get(i).showProduct();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(address, client.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
}
