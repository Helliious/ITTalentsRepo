package main;

import DBConnector.DBConnector;
import shipments.Shipment;
import util.Randomizator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Harbour {
    private final ArrayList<Queue<Ship>> docks;
    private final ArrayList<Warehouse> warehouses;
    private final HashSet<Shipment> shipments;

    Harbour() {
        docks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            docks.add(new LinkedList<>());
        }
        warehouses = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            warehouses.add(new Warehouse());
        }
        this.shipments = new HashSet<>();
    }

    protected synchronized void serviceShip(Ship ship) {
        int dockIdx = Randomizator.getRandomNum(0, 5);
        docks.get(dockIdx).offer(ship);
        if (docks.get(dockIdx).size() == 1) {
            notifyAll();
        }

        System.out.println(Thread.currentThread().getName() + " waits for unload!");
        while (!ship.isServiced()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        docks.get(dockIdx).remove(ship);
        System.out.println(Thread.currentThread().getName() + " unloaded and leaving!");
        if (!docks.get(dockIdx).isEmpty()) {
            notifyAll();
        }
    }

    protected synchronized int unloadShip(Crane crane) {
        while (!hasNonEmptyDocks()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int dockId = getDock();
        Queue<Ship> dock = docks.get(dockId);
        assert dock != null;
        Ship ship = dock.peek();
        assert ship != null;
        LinkedList<Package> packages = ship.unloadPackages();
        if (Randomizator.getRandomNum(0, 2) == 0) {
            warehouses.get(0).addPackages(packages);
        } else {
            warehouses.get(1).addPackages(packages);
        }

        String sql = "INSERT INTO shipments (" +
                "boat_name, " +
                "dock_id, " +
                "crane_id, " +
                "unloading_time, " +
                "package_id) " +
                "VALUES (?, ?, ?, ?, ?)";
        Connection connection = DBConnector.getInstance().getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);
            for (int i = 0; i < packages.size(); i++) {
                Shipment shipment = new Shipment(ship.getName(), dockId, crane.getCraneId(), new Timestamp(System.currentTimeMillis()), packages.get(i).getPackageId());
                shipments.add(shipment);
                ps.setString(1, shipment.getBoatName());
                ps.setInt(2, shipment.getDockId());
                ps.setInt(3, shipment.getCraneId());
                ps.setTimestamp(4, shipment.getUnloadingTime());
                ps.setInt(5, shipment.getPackageId());
                ps.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Error connecting to DB. " + e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Error setting autocommit: " + e.getMessage());
            }
        }
        ship.setServiced();
        notifyAll();
        return ship.getPackagesAmount();
    }

    private boolean hasNonEmptyDocks() {
        for (Queue<Ship> dock : docks) {
            if (!dock.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private int getDock() {
        int dockId = 0;
        for (Queue<Ship> dock : docks) {
            if (!dock.isEmpty()) {
                break;
            }
            dockId++;
        }
        return dockId;
    }

    protected synchronized void unloadWarehouse() {
        while (!hasNonEmptyWarehouse()) {
            try {
                System.out.println(Thread.currentThread().getName() + " cleared warehouses, waiting!");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        warehouses.get(Randomizator.getRandomNum(0, 2)).deliverPackage();
        System.out.println(Thread.currentThread().getName() + " delivered a package!");
        notifyAll();
    }

    private boolean hasNonEmptyWarehouse() {
        for (Warehouse warehouse : warehouses) {
            if (!warehouse.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
