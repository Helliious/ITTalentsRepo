package main;

public class Consumer implements Runnable {
    private AssembledParts assembledParts;

    Consumer(AssembledParts assembledParts) {
        this.assembledParts = assembledParts;
    }

    @Override
    public void run() {
        while (true) {
            assembledParts.assembleCar();
        }
    }
}
