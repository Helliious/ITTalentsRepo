package main;

import main.vehicleParts.*;

import java.util.Queue;

public class Producer implements Runnable {
    AssembledParts assembledParts;
    Queue<carPartKind> creationPattern;

    Producer(AssembledParts assembledParts,
            Queue<carPartKind> creationPattern) {
        this.assembledParts = assembledParts;
        this.creationPattern = creationPattern;
    }

    @Override
    public void run() {
        while (true) {
            carPartKind kind = creationPattern.remove();
            CarPart newPart;
            switch (kind) {
                case SEAT:
                    newPart = new Seat();
                    break;
                case TIRE:
                    newPart = new Tire();
                    break;
                case ENGINE:
                    newPart = new Engine();
                    break;
                default:
                    newPart = new Frame();
                    break;
            }
            try {
                Thread.sleep(newPart.getAssembleTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            assembledParts.addPart(newPart);
            System.out.println(newPart.getName() + " was build!");
            creationPattern.offer(kind);
        }
    }
}
