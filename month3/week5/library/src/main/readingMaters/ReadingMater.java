package main.readingMaters;

import main.Library;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.HashMap;
import java.util.Objects;
import java.util.TreeMap;

public abstract class ReadingMater {
    private static int id = 0;
    private final String name;
    private final String publishingHouse;
    private final HashMap<LocalDate, LocalDate> takingHistory;
    private final int readingMatterId;
    private final ReadingMaterType type;
    private final TreeMap<LocalDateTime, LocalDateTime> rentableChronology;
    private Thread checker;
    private final Library library;

    public ReadingMater(String name, String publishingHouse, ReadingMaterType type, Library library) {
        this.library = library;
        this.name = name;
        this.publishingHouse = publishingHouse;
        this.takingHistory = new HashMap<>();
        this.type = type;
        this.readingMatterId = id++;
        this.rentableChronology = new TreeMap<>();
    }

    public String getName() {
        return name;
    }

    public ReadingMaterType getType() {
        return type;
    }

    public void markTaken() {
        rentableChronology.put(LocalDateTime.now(), null);
        this.checker = new Thread(() -> {
            try {
                Thread.sleep(getRentDuration().getSeconds()*1000);
                System.out.println("The book " + name + " had to be already returned! Shame on you!");
                while (true) {
                    Thread.sleep(1000);
                    System.out.println("Calculating 1% tax fee.");
                    library.increaseTax(this);
                    if (Thread.currentThread().isInterrupted()) {
                        return;
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Checker for " + name + " stopped.");
            }
        });
        checker.start();
    }

    public void markReturned() {
        rentableChronology.put(rentableChronology.lastKey(), LocalDateTime.now());
        checker.interrupt();
    }

    public abstract String getKind();
    public abstract Duration getRentDuration();
    public abstract double getPrice();

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
