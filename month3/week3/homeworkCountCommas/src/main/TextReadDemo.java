package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TextReadDemo {
    public static void main(String[] args) {
        File f = new File("warAndPeace.txt");
        StringBuilder text = new StringBuilder();
        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                text.append(sc.nextLine());
                text.append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Commas: " + countCommas(text.toString(), 4));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static int countCommas(String text, int threadsCount) throws InterruptedException {
        Queue<String> partialTexts = new LinkedList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(threadsCount);
        int subStrStart = 0;
        int subStrStep = text.length() / threadsCount;
        for (int i = 0; i < threadsCount; i++) {
            if (i == threadsCount - 1) {
                partialTexts.offer(text.substring(subStrStart));
            } else {
                partialTexts.offer(text.substring(subStrStart, subStrStart + subStrStep));
            }
            subStrStart += subStrStep;
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < threadsCount; i++) {
            executorService.submit(new Worker(partialTexts.remove()));
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException ex) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Code executed in: " + (endTime - startTime) + " milliseconds");

        return Worker.commasCount.get();
    }
}
