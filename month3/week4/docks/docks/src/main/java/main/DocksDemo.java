package main;

import loggers.Logger;

public class DocksDemo {
    public static void main(String[] args) {
        Harbour harbour = new Harbour();
        Ship ship1 = new Ship(harbour, "Ship-1");
        Ship ship2 = new Ship(harbour, "Ship-2");
        Ship ship3 = new Ship(harbour, "Ship-3");
        Ship ship4 = new Ship(harbour, "Ship-4");
        Ship ship5 = new Ship(harbour, "Ship-5");
        Ship ship6 = new Ship(harbour, "Ship-6");
        Ship ship7 = new Ship(harbour, "Ship-7");
        Ship ship8 = new Ship(harbour, "Ship-8");
        Ship ship9 = new Ship(harbour, "Ship-9");
        Ship ship10 = new Ship(harbour, "Ship-10");
        ship1.start();
        ship2.start();
        ship3.start();
        ship4.start();
        ship5.start();
        ship6.start();
        ship7.start();
        ship8.start();
        ship9.start();
        ship10.start();

        Crane crane1 = new Crane(harbour, "Crane-1");
        Crane crane2 = new Crane(harbour, "Crane-2");
        crane1.start();
        crane2.start();

        Distributor distributor1 = new Distributor(harbour, "Distributor-1");
        Distributor distributor2 = new Distributor(harbour, "Distributor-2");
        distributor1.start();
        distributor2.start();

        Logger logger = new Logger();
        logger.setDaemon(true);
        logger.start();
    }
}
