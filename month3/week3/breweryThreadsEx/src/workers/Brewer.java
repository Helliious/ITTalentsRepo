package workers;

import main.Brewery;
import main.Caldron;

public class Brewer implements Runnable {
    private final Brewery brewery;

    public Brewer(Brewery brewery) {
        this.brewery = brewery;
    }

    @Override
    public void run() {
        Caldron caldron;
        while (true) {
            caldron = brewery.getFullCaldron();
            if (caldron != null) {
                caldron.brew();
                System.out.println("Emptied a Caldron!");
            }
        }
    }
}
