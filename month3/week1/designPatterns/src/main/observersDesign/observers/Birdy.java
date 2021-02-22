package main.observersDesign.observers;

import main.observersDesign.Nature;

public class Birdy implements NatureObserver {
    @Override
    public void react(Nature.NatureEvent e) {
        switch (e) {
            case FIRE:
                System.out.println("Birdy doesn't care!");
                break;
            case FLOOD:
                System.out.println("Birdy fly away!");
                break;
            case EARTHQUAKE:
                System.out.println("Birdy scared!");
                break;
            default:
                System.out.println("Birdy dead!");
                break;
        }
    }
}
