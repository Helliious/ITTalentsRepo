package loggers;

import DBConnector.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class Logger extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            listAllShipsPerDock();
            listAllPackagesPerCrane();
            showShipDeliveredMostPackages();
        }
    }

    private void showShipDeliveredMostPackages() {
        String sql = "SELECT boat_name, COUNT(package_id) AS package_count FROM shipments GROUP BY boat_name ORDER BY package_count LIMIT 1";
        Connection connection = DBConnector.getInstance().getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                System.out.println(result.getString("boat_name") + " : " + result.getInt("package_count"));
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to DB: " + e.getMessage());
        }
    }

    private void listAllPackagesPerCrane() {
        String sql = "SELECT crane_id, COUNT(package_id) AS package_count FROM shipments GROUP BY crane_id";
        TreeMap<Integer, Integer> unloadedShips = new TreeMap<>();
        Connection connection = DBConnector.getInstance().getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                unloadedShips.put(result.getInt("crane_id"), result.getInt("package_count"));
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to DB: " + e.getMessage());
        }

        for (Map.Entry<Integer, Integer> stats : unloadedShips.entrySet()) {
            System.out.println("Crane " + stats.getKey() + " : " + stats.getValue() + " packages");
        }
    }

    private void listAllShipsPerDock() {
        String sql = "SELECT dock_id, COUNT(DISTINCT boat_name) AS boat_count FROM shipments GROUP BY dock_id";
        TreeMap<Integer, Integer> unloadedShips = new TreeMap<>();
        Connection connection = DBConnector.getInstance().getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                unloadedShips.put(result.getInt("dock_id"), result.getInt("boat_count"));
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to DB: " + e.getMessage());
        }

        for (Map.Entry<Integer, Integer> stats : unloadedShips.entrySet()) {
            System.out.println("Dock " + stats.getKey() + " : " + stats.getValue() + " ships");
        }
    }
}
