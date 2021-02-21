package main.observersDesign;

import main.observersDesign.observers.NatureObserver;

import java.util.ArrayList;

public class Nature {
    public enum NatureEvent {
        FIRE, FLOOD, EARTHQUAKE
    }

    private static Nature instance;
    private final ArrayList<NatureObserver> observers;

    public static Nature getInstance() {
        if (instance == null) {
            instance = new Nature();
        }
        return instance;
    }

    Nature() {
        observers = new ArrayList<>();
    }

    void subscribe(NatureObserver observer) {
        observers.add(observer);
    }

    void unsubscribe(NatureObserver observer) {
        observers.remove(observer);
    }

    void notifyAllObservers(NatureEvent e) {
        for (NatureObserver o : observers) {
            o.react(e);
        }
    }

    void fireEvent() {
        System.out.println("Fire in the woods!");
        notifyAllObservers(NatureEvent.FIRE);
    }

    void floodEvent() {
        System.out.println("Flood in the woods!");
        notifyAllObservers(NatureEvent.FLOOD);
    }

    void earthQuakeEvent() {
        System.out.println("Earthquake in the woods!");
        notifyAllObservers(NatureEvent.EARTHQUAKE);
    }
}
