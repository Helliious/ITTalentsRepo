package shipments;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

public class Shipment {
    private final String boatName;
    private final int dockId;
    private final int craneId;
    private final Timestamp unloadingTime;
    private final int packageId;

    public Shipment(String boatName, int dockId, int craneId, Timestamp unloadingTime, int packageId) {
        this.boatName = boatName;
        this.dockId = dockId;
        this.craneId = craneId;
        this.unloadingTime = unloadingTime;
        this.packageId = packageId;
    }

    public String getBoatName() {
        return boatName;
    }

    public int getDockId() {
        return dockId;
    }

    public int getCraneId() {
        return craneId;
    }

    public Timestamp getUnloadingTime() {
        return unloadingTime;
    }

    public int getPackageId() {
        return packageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipment shipment = (Shipment) o;
        return dockId == shipment.dockId && craneId == shipment.craneId && packageId == shipment.packageId && Objects.equals(boatName, shipment.boatName) && Objects.equals(unloadingTime, shipment.unloadingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boatName, dockId, craneId, unloadingTime, packageId);
    }
}
