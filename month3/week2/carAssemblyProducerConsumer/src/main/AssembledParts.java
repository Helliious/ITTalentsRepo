package main;

import main.vehicleParts.CarPart;
import main.vehicleParts.carPartKind;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class AssembledParts {
    HashMap<carPartKind, Queue<CarPart>> producedParts;

    AssembledParts() {
        producedParts = new HashMap<>();
    }

    private boolean canAssembleCar() {
        boolean isReadyForAssemble = false;
        if (producedParts.containsKey(carPartKind.ENGINE) &&
                producedParts.containsKey(carPartKind.FRAME) &&
                producedParts.containsKey(carPartKind.SEAT) &&
                producedParts.containsKey(carPartKind.TIRE)) {
            if (!producedParts.get(carPartKind.ENGINE).isEmpty() &&
                    !producedParts.get(carPartKind.FRAME).isEmpty()) {
                if (producedParts.get(carPartKind.SEAT).size() >= 5 &&
                        producedParts.get(carPartKind.TIRE).size() >= 4) {
                    isReadyForAssemble = true;
                }
            }
        }
        return isReadyForAssemble;
    }

    private void carAssemble() {
        if (canAssembleCar()) {
            producedParts.get(carPartKind.ENGINE).remove();
            producedParts.get(carPartKind.FRAME).remove();
            for (int i = 0; i < 5; i++) {
                producedParts.get(carPartKind.SEAT).remove();
            }
            for (int i = 0; i < 4; i++) {
                producedParts.get(carPartKind.TIRE).remove();
            }
            System.out.println("\nAssembled new car!\n");
        }
    }

    private void checkMapKey(carPartKind kind) {
        if (!producedParts.containsKey(kind)) {
            producedParts.put(kind, new LinkedList<>());
        }
    }

    synchronized void assembleCar() {
        if (!canAssembleCar()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        carAssemble();
        notifyAll();
    }

    synchronized void addPart(CarPart newCarPart) {
        if (canAssembleCar()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        checkMapKey(newCarPart.getKind());
        producedParts.get(newCarPart.getKind()).offer(newCarPart);
        notifyAll();
    }
}
