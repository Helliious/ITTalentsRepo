package main;

import main.vehicleParts.CarPart;
import main.vehicleParts.carPartKind;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class Demo {
    public static void main(String[] args) {
        ConcurrentHashMap<carPartKind, Queue<CarPart>> producedParts = new ConcurrentHashMap<>();
        Queue<carPartKind> firstLinePattern = new LinkedList<>();
        firstLinePattern.offer(carPartKind.ENGINE);
        firstLinePattern.offer(carPartKind.TIRE);
        firstLinePattern.offer(carPartKind.SEAT);
        Queue<carPartKind> secondLinePattern = new LinkedList<>();
        secondLinePattern.offer(carPartKind.FRAME);
        secondLinePattern.offer(carPartKind.TIRE);
        secondLinePattern.offer(carPartKind.TIRE);
        secondLinePattern.offer(carPartKind.TIRE);
        Queue<carPartKind> thirdLinePattern = new LinkedList<>();
        thirdLinePattern.offer(carPartKind.SEAT);
        thirdLinePattern.offer(carPartKind.SEAT);
        thirdLinePattern.offer(carPartKind.SEAT);
        thirdLinePattern.offer(carPartKind.SEAT);

        AssembledParts assembledParts = new AssembledParts();
        Producer firstProducer = new Producer(assembledParts, firstLinePattern);
        Producer secondProducer = new Producer(assembledParts, secondLinePattern);
        Producer thirdProducer = new Producer(assembledParts, thirdLinePattern);
        Consumer consumer = new Consumer(assembledParts);
        Thread firstProducerThread = new Thread(firstProducer);
        Thread secondProducerThread = new Thread(secondProducer);
        Thread thirdProducerThread = new Thread(thirdProducer);
        Thread consumerThread = new Thread(consumer);

        firstProducerThread.start();
        secondProducerThread.start();
        thirdProducerThread.start();
        consumerThread.start();
    }
}
