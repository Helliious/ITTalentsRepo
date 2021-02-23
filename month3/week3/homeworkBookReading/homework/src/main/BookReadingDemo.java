package main;

import java.io.*;
import java.util.*;

public class BookReadingDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> repeatsCount = new HashMap<>();
        LinkedHashMap<String, Integer> sortedWords;
        File f = new File("warAndPeace.txt");
        int countLines = 0;
        int countWords = 0;
        int countCommas = 0;
        int countWar = 0;
        int countPeace = 0;
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
                String[] words = line.trim().split("\\s*(\\s|,)\\s*");
                for (int i = 0; i < words.length; i++) {
                    if (words[i].toLowerCase().contains("война")) {
                        countWar++;
                    } else if (words[i].toLowerCase().contains("мир")) {
                        countPeace++;
                    }

                    if (!repeatsCount.containsKey(words[i])) {
                        repeatsCount.put(words[i], 0);
                    }
                    repeatsCount.put(words[i], repeatsCount.get(words[i]) + 1);
                }
                countWords += words.length;
                countCommas += line.trim().split(",").length;
                countLines++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        sortedWords = mostCommonWords(repeatsCount, 10);
        Map.Entry<String, Integer> mostCommonWord = sortedWords.entrySet().iterator().next();
        
        System.out.println("Lines count: " + countLines);
        System.out.println("Words count: " + countWords);
        System.out.println("Commas count: " + countCommas);
        System.out.println("Most common word is " + mostCommonWord.getKey() + " appeared: " + mostCommonWord.getValue() + " times");
        if (countWar > countPeace) {
            System.out.println("War is more common War - " + countWar + ", Peace - " + countPeace);
        } else if (countWar < countPeace) {
            System.out.println("Peace is more common Peace - " + countPeace + ", War - " + countWar);
        } else {
            System.out.println("War and Peace are equally common War - " + countWar + ", Peace - " + countPeace);
        }
        System.out.println("Ten most common words:");
        for (Map.Entry<String, Integer> word : sortedWords.entrySet()) {
            System.out.println(word.getKey() + ": " + word.getValue());
        }
    }

    static LinkedHashMap<String, Integer> mostCommonWords(HashMap<String, Integer> repeatsCount, int numberOfWords) {
        LinkedHashMap<String, Integer> sortedWords = new LinkedHashMap<>();
        int mostCommonWordCount;
        String mostCommonWord = null;
        while (numberOfWords > 0) {
            mostCommonWordCount = 0;
            for (Map.Entry<String, Integer> word : repeatsCount.entrySet()) {
                if (mostCommonWordCount < word.getValue()) {
                    mostCommonWord = word.getKey();
                    mostCommonWordCount = word.getValue();
                }
            }
            assert mostCommonWord != null;
            if ((mostCommonWord.charAt(0) >= 'a' && mostCommonWord.charAt(0) <= 'я') ||
                    (mostCommonWord.charAt(0) >= 'А' && mostCommonWord.charAt(0) <= 'Я')) {
                sortedWords.put(mostCommonWord, mostCommonWordCount);
                numberOfWords--;
            }
            repeatsCount.remove(mostCommonWord);
        }
        return sortedWords;
    }
}
