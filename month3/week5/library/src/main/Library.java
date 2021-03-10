package main;

import main.readingMaters.*;
import main.util.Randomizator;

import java.time.LocalDateTime;
import java.util.*;

public class Library {
    private final HashMap<ReadingMaterType, TreeMap<String, HashMap<String, ArrayList<ReadingMater>>>> readingMaters;
    private final HashMap<IRentable, TreeMap<LocalDateTime, LocalDateTime>> chronology;

    Library() {
        this.readingMaters = new HashMap<>();
        this.chronology = new HashMap<>();
        loadBooks();
    }

    private void loadBooks() {
        ReadingMater readingMater;
        for (int i = 0; i < 30; i++) {
            int readingMatterChance = Randomizator.getRandNum(0, 100);
            if (readingMatterChance <= 33) {
                readingMater = new Book();
                addBook(readingMater, ReadingMaterType.BOOK);
            } else if (readingMatterChance <= 66) {
                readingMater = new Magazine();
                addBook(readingMater, ReadingMaterType.MAGAZINE);
            } else {
                readingMater = new SchoolBook();
                addBook(readingMater, ReadingMaterType.SCHOOL_BOOK);
            }
        }
    }

    private void addBook(ReadingMater readingMater, ReadingMaterType readingMaterType) {
        if (!readingMaters.containsKey(readingMaterType)) {
            readingMaters.put(readingMaterType, new TreeMap<>((s1, s2) -> s1.compareTo(s2)));
        }
        if (!readingMaters.get(readingMaterType).containsKey(readingMater.getKind())) {
            readingMaters.get(readingMaterType).put(readingMater.getKind(), new HashMap<>());
        }
        if (!readingMaters.get(readingMaterType).get(readingMater.getKind()).containsKey(readingMater.getName())) {
            readingMaters.get(readingMaterType).get(readingMater.getKind()).put(readingMater.getName(), new ArrayList<>());
        }
        readingMaters.get(readingMaterType).get(readingMater.getKind()).get(readingMater.getName()).add(readingMater);
    }

    //TODO: Implement renting a book method for threads
    public ReadingMater rentABook() {
        return null;
    }

    //TODO: Implement methods for thread logic

    public void showReadingMaters() {
        for (Map.Entry<ReadingMaterType, TreeMap<String, HashMap<String, ArrayList<ReadingMater>>>> books : readingMaters.entrySet()) {
            System.out.println(books.getKey() + ":");
            for (Map.Entry<String, HashMap<String, ArrayList<ReadingMater>>> bookKind : books.getValue().entrySet()) {
                System.out.println("\t" + bookKind.getKey() + ":");
                for (Map.Entry<String, ArrayList<ReadingMater>> specificBook : bookKind.getValue().entrySet()) {
                    specificBook.getValue().sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
                    for (ReadingMater book : specificBook.getValue()) {
                        System.out.println("\t\t" + specificBook.getKey());
                    }
                }
            }
        }
    }

}
