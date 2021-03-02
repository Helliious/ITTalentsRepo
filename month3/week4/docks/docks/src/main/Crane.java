package main;

public class Crane extends Thread {
    private final Harbour harbour;

    Crane(Harbour harbour, String name) {
        super(name);
        this.harbour = harbour;
    }

    @Override
    public void run() {
        while (true) {
            int time = harbour.unloadShip();
            try {
                Thread.sleep(time * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
