package main;

public class Client extends Thread {
    private final Moussaka moussaka;

    Client(Moussaka moussaka, String name) {
        super(name);
        this.moussaka = moussaka;
    }

    @Override
    public void run() {
        while (true) {
            moussaka.deliver();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
