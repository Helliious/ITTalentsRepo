package main;

import main.workers.Cooker;
import main.workers.Gatherer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BreweryDemo {
    public static void main(String[] args) {
        BlockingQueue<Caldron> caldrons = new ArrayBlockingQueue<>(2);
        for (int i = 0; i < 2; i++) {
            try {
                caldrons.put(new Caldron());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Brewery brewery = new Brewery(caldrons);
        Cooker cooker1 = new Cooker("Pesho", 23, brewery);
        Cooker cooker2 = new Cooker("Gesho", 29, brewery);
//        Cooker cooker3 = new Cooker("Resho", 20, brewery);
        Gatherer gatherer1 = new Gatherer("Ivan", 15, brewery);
        Gatherer gatherer2 = new Gatherer("Tosho", 15, brewery);
//        Gatherer gatherer3 = new Gatherer("Gosho", 15, brewery);
//        Gatherer gatherer4 = new Gatherer("Rosho", 15, brewery);
//        Gatherer gatherer5 = new Gatherer("Bosho", 15, brewery);

        Thread cookerThread1 = new Thread(cooker1);
        Thread cookerThread2 = new Thread(cooker2);
//        Thread cookerThread3 = new Thread(cooker3);
        Thread gathererThread1 = new Thread(gatherer1);
        Thread gathererThread2 = new Thread(gatherer2);
//        Thread gathererThread3 = new Thread(gatherer3);
//        Thread gathererThread4 = new Thread(gatherer4);
//        Thread gathererThread5 = new Thread(gatherer5);

        cookerThread1.start();
        cookerThread2.start();
//        cookerThread3.start();
        gathererThread1.start();
        gathererThread2.start();
//        gathererThread3.start();
//        gathererThread4.start();
//        gathererThread5.start();
    }
}
