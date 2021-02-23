package main;

import java.io.*;
import java.util.*;

public class BookReadingDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> repeatsCount = new HashMap<>();
        HashMap<Integer, TreeSet<String>> wordsByLength = new HashMap<>();
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
                String[] words = line.trim().split("\\P{L}+");
                for (int i = 0; i < words.length; i++) {
                    addWordByLength(wordsByLength, words[i]);
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
        
        System.out.println("Lines count: " + countLines);
        System.out.println("Words count: " + countWords);
        System.out.println("Commas count: " + countCommas);
        showWarOrPeace(countWar, countPeace);
        showCommonWords(repeatsCount, 10);
        saveWordsByLengthInFiles(wordsByLength);
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
            if (mostCommonWord.length() > 0 && isAWord(mostCommonWord)) {
                sortedWords.put(mostCommonWord, mostCommonWordCount);
                numberOfWords--;
            }
            repeatsCount.remove(mostCommonWord);
        }
        return sortedWords;
    }

    static void addWordByLength(HashMap<Integer, TreeSet<String>> wordsByLength, String word) {
        if (word.length() > 0 && isAWord(word)) {
            if (!wordsByLength.containsKey(word.length())) {
                wordsByLength.put(word.length(), new TreeSet<>((w1, w2) -> w1.compareTo(w2)));
            }
            wordsByLength.get(word.length()).add(word);
        }
    }

    static void showWarOrPeace(int countWar, int countPeace) {
        if (countWar > countPeace) {
            System.out.println("War is more common War - " + countWar + ", Peace - " + countPeace);
        } else if (countWar < countPeace) {
            System.out.println("Peace is more common Peace - " + countPeace + ", War - " + countWar);
        } else {
            System.out.println("War and Peace are equally common War - " + countWar + ", Peace - " + countPeace);
        }
    }

    static void showCommonWords(HashMap<String, Integer> repeatsCount, int amountOfWords) {
        LinkedHashMap<String, Integer> sortedWords = mostCommonWords(repeatsCount, amountOfWords);
        System.out.println("Most common words:");
        for (Map.Entry<String, Integer> word : sortedWords.entrySet()) {
            System.out.println(word.getKey() + ": " + word.getValue());
        }
    }

    static boolean isAWord(String word) {
        return (word.charAt(0) >= 'a' && word.charAt(0) <= 'я') ||
                (word.charAt(0) >= 'А' && word.charAt(0) <= 'Я') ||
                (word.charAt(0) >= 'a' && word.charAt(0) <= 'z') ||
                (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z');
    }

    static void saveWordsByLengthInFiles(HashMap<Integer, TreeSet<String>> wordsByLength) {
        for (Map.Entry<Integer, TreeSet<String>> words : wordsByLength.entrySet()) {
            File f = new File(words.getKey().toString() + "lettersWords.txt");
            int wordsPerLine = 0;
            if (f.exists()) {
                f.delete();
            } else {
                try {
                    f.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try (FileWriter fos = new FileWriter(f)) {
                for (String word : words.getValue()) {
                    fos.write(word);
                    fos.write(", ");
                    wordsPerLine++;
                    if (wordsPerLine >= 10) {
                        wordsPerLine = 0;
                        fos.write("\n");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
