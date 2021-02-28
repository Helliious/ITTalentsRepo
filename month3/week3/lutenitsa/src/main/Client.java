package main;

public class Client extends Thread {
    private final Tray tray;

    Client(Tray tray) {
        this.tray = tray;
    }

    @Override
    public void run() {
        while (true) {
            tray.deliver();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
