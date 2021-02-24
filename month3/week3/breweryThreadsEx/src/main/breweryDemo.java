package main;

import workers.Brewer;
import workers.Gatherer;

public class breweryDemo {
    public static void main(String[] args) {
        Brewery brewery = new Brewery();
        for (int i = 0; i < 5; i++) {
            brewery.addCaldron(new Caldron());
        }
        Brewer brewer = new Brewer(brewery);
        Gatherer gatherer1 = new Gatherer(brewery);
        Gatherer gatherer2 = new Gatherer(brewery);

        Thread t1 = new Thread(gatherer1);
        Thread t3 = new Thread(brewer);
        Thread t2 = new Thread(gatherer2);

        t1.start();
        t2.start();
        t3.start();
    }
}
