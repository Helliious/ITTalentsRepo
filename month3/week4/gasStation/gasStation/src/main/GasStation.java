package main;

import util.Randomizator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GasStation {
    volatile ArrayList<Queue<Vehicle>> chargingColumns;
    volatile ArrayList<Queue<Vehicle>> cashRegisters;

    GasStation() {
        chargingColumns = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            chargingColumns.add(new LinkedList<>());
        }
        cashRegisters = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            cashRegisters.add(new LinkedList<>());
        }
    }

    protected synchronized void loadVehicle(Vehicle vehicle) {
        int columnIdx = Randomizator.getRandomNum(0, 5);
        chargingColumns.get(columnIdx).offer(vehicle);
        if (chargingColumns.get(columnIdx).size() == 1) {
            notifyAll();
        }
        System.out.println(Thread.currentThread().getName() + " waiting for a charge!");
        while (!vehicle.isCharged()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " charged!");
        int cashRegisterIdx = Randomizator.getRandomNum(0, 2);
        cashRegisters.get(cashRegisterIdx).offer(vehicle);
        while (!vehicle.isServiced()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cashRegisters.get(cashRegisterIdx).remove();
        System.out.println(Thread.currentThread().getName() + " is loaded and leaving!");
        if (!chargingColumns.get(columnIdx).isEmpty()) {
            notifyAll();
        }
    }

    protected synchronized void loadFuel() {
        while (!hasNonEmptyColumn()) {
            try {
                System.out.println(Thread.currentThread().getName() + " - no waiting cars on column, waiting!");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Queue<Vehicle> vehicles = getNonEmptyColumn();
        assert vehicles != null;
        assert vehicles.peek() != null;
        vehicles.remove().setCharged();
        notifyAll();
    }

    private boolean hasNonEmptyColumn() {
        for (int i = 0; i < chargingColumns.size(); i++) {
            if (!chargingColumns.get(i).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private Queue<Vehicle> getNonEmptyColumn() {
        for (int i = 0; i < chargingColumns.size(); i++) {
            if (!chargingColumns.get(i).isEmpty()) {
                return chargingColumns.get(i);
            }
        }
        return null;
    }

    protected synchronized void serviceCustomer() {
        while (!hasNonEmptyCashRegister()) {
            try {
                System.out.println(Thread.currentThread().getName() + " - cash register empty, waiting!");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Queue<Vehicle> vehicles = getNonEmptyCashRegister();
        assert vehicles != null;
        assert vehicles.peek() != null;
        vehicles.peek().setServiced();
        notifyAll();
    }

    private boolean hasNonEmptyCashRegister() {
        for (int i = 0; i < cashRegisters.size(); i++) {
            if (!cashRegisters.get(i).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private Queue<Vehicle> getNonEmptyCashRegister() {
        for (int i = 0; i < cashRegisters.size(); i++) {
            if (!cashRegisters.get(i).isEmpty()) {
                return cashRegisters.get(i);
            }
        }
        return null;
    }
}
