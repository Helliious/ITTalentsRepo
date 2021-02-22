package main.vehicleParts;

import java.util.Objects;

public abstract class CarPart {
    private static int id = 0;
    private final String name;
    private final int partId;

    CarPart(String name) {
        this.name = name;
        this.partId = id++;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPart carPart = (CarPart) o;
        return partId == carPart.partId && Objects.equals(name, carPart.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, partId);
    }

    public abstract carPartKind getKind();
    public abstract int getAssembleTime();
}
