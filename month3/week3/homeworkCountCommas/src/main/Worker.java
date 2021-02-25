package main;

import java.util.concurrent.atomic.AtomicInteger;

public class Worker extends Thread {
    static volatile AtomicInteger commasCount;
    private final String text;

    Worker(String text) {
        this.text = text;
        commasCount = new AtomicInteger(0);
    }

    @Override
    public void run() {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ',') {
                commasCount.incrementAndGet();
            }
        }
    }
}
