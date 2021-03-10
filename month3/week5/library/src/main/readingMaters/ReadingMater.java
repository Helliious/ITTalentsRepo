package main.readingMaters;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;

public abstract class ReadingMater {
    private static int id = 0;
    private final String name;
    private final String publishingHouse;
    private final HashMap<LocalDate, LocalDate> takingHistory;
    private final int readingMatterId;

    public ReadingMater(String name, String publishingHouse) {
        this.name = name;
        this.publishingHouse = publishingHouse;
        this.takingHistory = new HashMap<>();
        this.readingMatterId = id++;
    }

    public String getName() {
        return name;
    }

    public abstract String getKind();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReadingMater that = (ReadingMater) o;
        return readingMatterId == that.readingMatterId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(readingMatterId);
    }
}
