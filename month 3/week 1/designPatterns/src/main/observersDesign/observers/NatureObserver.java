package main.observersDesign.observers;

import main.observersDesign.Nature;

public interface NatureObserver {
    void react(Nature.NatureEvent e);
}
