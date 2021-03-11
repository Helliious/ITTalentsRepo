package main.clients;

import main.Library;
import main.readingMaters.BookNotFoundException;
import main.readingMaters.ReadingMater;
import main.util.Randomizator;

public class Client extends Thread {
    private final Library library;
    private double money;

    public Client(Library library) {
        this.library = library;
        this.money = 50;
    }

    public void spendMoney(double tax) {
        this.money -= tax;
    }

    @Override
    public void run() {
        while (true) {
            try {
                ReadingMater readingMater = library.rentABook();
                Thread.sleep(Randomizator.getRandNum(1000, 6000));
                library.returnBook(readingMater, this);
            } catch (BookNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
