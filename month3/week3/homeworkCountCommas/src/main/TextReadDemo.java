package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TextReadDemo {
    public static void main(String[] args) {
        File f = new File("warAndPeace.txt");
        StringBuilder text = new StringBuilder();
        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                text.append(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Commas: " + countCommas(text.toString(), 32));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static int countCommas(String text, int threadsCount) throws InterruptedException {
        Queue<String> partialTexts = new LinkedList<>();
        ArrayList<Worker> workers = new ArrayList<>();
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

        for (int i = 0; i < threadsCount; i++) {
            workers.add(new Worker(partialTexts.remove()));
        }
        long startTime = System.currentTimeMillis();
        for (Worker worker : workers) {
            worker.start();
            worker.join();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Code executed in: " + (endTime - startTime) + " milliseconds");

        int result = 0;
        for (Worker worker : workers) {
            result += worker.getCommasCount();
        }
        return result;
    }
}
