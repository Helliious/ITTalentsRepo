package main.observersDesign;

import main.observersDesign.observers.Birdy;
import main.observersDesign.observers.Fishy;
import main.observersDesign.observers.NatureObserver;

public class ObserverDesignDemo {
    public static void main(String[] args) {
        Nature nature = new Nature();
        NatureObserver birdy = new Birdy();
        NatureObserver fishy = new Fishy();

        nature.subscribe(birdy);
        nature.subscribe(fishy);

        nature.fireEvent();
        nature.floodEvent();
    }
}
