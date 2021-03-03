package main;

import main.clients.Client;
import main.util.Randomizator;

import java.util.ArrayList;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank("DSK", "bul. Geo Mil 11");
        ArrayList<Client> clients = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            clients.add(new Client());
        }

        for (int i = 0; i < 10; i++) {
            int percent = Randomizator.randomNumRange(80, 101);
            double moneyDeposit = (clients.get(i).getPocketMoney() * percent) / 100;
            clients.get(i).makeDeposit(moneyDeposit, bank);
        }
        bank.showAvailability();

        for (int i = 0; i < 10; i++) {
            double amount = Randomizator.randomNumRange(500, 1200);
            int period = Randomizator.randomNumRange(1, 12);
            clients.get(i).askForCredit(amount, period, bank);
        }
        bank.payAnnualInterest();
        bank.showAvailability();

        for (int i = 0; i < 10; i++) {
            clients.get(i).payDay();
            clients.get(i).makeAnnualPayment(bank);
        }
        bank.showAvailability();
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).showClientInfo();
        }
        System.out.println("--------------------------------");
    }
}
