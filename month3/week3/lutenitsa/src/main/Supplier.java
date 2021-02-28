package main;

public class Supplier extends Thread {
    private final Sack sack;

    Supplier(Sack sack, String name) {
        super(name);
        this.sack = sack;
    }

    @Override
    public void run() {
        while (true) {
            sack.fill();
        }
    }
}
