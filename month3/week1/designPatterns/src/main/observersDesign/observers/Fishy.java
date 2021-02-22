package main.observersDesign.observers;

import main.observersDesign.Nature;

public class Fishy implements NatureObserver {
    @Override
    public void react(Nature.NatureEvent e) {
        switch (e) {
            case FIRE:
                System.out.println("Fishy doesn't care!");
                break;
            case FLOOD:
                System.out.println("Fishy is happy!");
                break;
            case EARTHQUAKE:
                System.out.println("Fishy is shaken!");
                break;
            default:
                System.out.println("Fishy dead!");
                break;
        }
    }
}
