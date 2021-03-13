package main;

public class Crane extends Thread {
    private static int id = 1;
    private final Harbour harbour;
    private final int craneId;

    Crane(Harbour harbour, String name) {
        super(name);
        this.harbour = harbour;
        craneId = id++;
    }

    public int getCraneId() {
        return craneId;
    }

    @Override
    public void run() {
        while (true) {
            int time = harbour.unloadShip(this);
            try {
                Thread.sleep(time * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
