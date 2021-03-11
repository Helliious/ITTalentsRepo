package main;

import main.clients.Client;
import main.constants.Constants;
import main.readingMaters.*;
import main.util.Randomizator;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Library {
    private final HashMap<ReadingMaterType, TreeMap<String, HashMap<String, LinkedList<ReadingMater>>>> readingMaters;
    private final ConcurrentHashMap<ReadingMater, TreeMap<LocalDateTime, LocalDateTime>> chronology;
    private final ConcurrentHashMap<ReadingMater, Double> taxes;
    private double money;
    private final Object lock = new Object();

    Library() {
        this.readingMaters = new HashMap<>();
        this.chronology = new ConcurrentHashMap<>();
        this.taxes = new ConcurrentHashMap<>();
        this.money = 100;
        loadBooks();
    }

    private void loadBooks() {
        ReadingMater readingMater;
        for (int i = 0; i < 30; i++) {
            int readingMatterChance = Randomizator.getRandNum(0, 100);
            if (readingMatterChance <= 33) {
                readingMater = new Book(this);
            } else if (readingMatterChance <= 66) {
                readingMater = new Magazine(this);
            } else {
                readingMater = new SchoolBook(this);
            }
            addBook(readingMater);
        }
    }

    private void addBook(ReadingMater readingMater) {
        if (!readingMaters.containsKey(readingMater.getType())) {
            readingMaters.put(readingMater.getType(), new TreeMap<>((s1, s2) -> s1.compareTo(s2)));
        }
        if (!readingMaters.get(readingMater.getType()).containsKey(readingMater.getKind())) {
            readingMaters.get(readingMater.getType()).put(readingMater.getKind(), new HashMap<>());
        }
        if (!readingMaters.get(readingMater.getType()).get(readingMater.getKind()).containsKey(readingMater.getName())) {
            readingMaters.get(readingMater.getType()).get(readingMater.getKind()).put(readingMater.getName(), new LinkedList<>());
        }
        readingMaters.get(readingMater.getType()).get(readingMater.getKind()).get(readingMater.getName()).add(readingMater);
    }

    public ReadingMater rentABook() throws BookNotFoundException {
        ReadingMaterType type = Randomizator.getRandNum(0, 2) == 0 ? ReadingMaterType.BOOK : ReadingMaterType.SCHOOL_BOOK;
        ReadingMater readingMater;
        synchronized (lock) {
            readingMater = getReadingMater(type);
            if (readingMater == null) {
                throw new BookNotFoundException();
            }
            readingMaters.get(type).get(readingMater.getKind()).get(readingMater.getName()).remove(readingMater);
        }
        if (!chronology.containsKey(readingMater)) {
            chronology.put(readingMater, new TreeMap<>());
        }
        chronology.get(readingMater).put(LocalDateTime.now(), LocalDateTime.now().plus(readingMater.getRentDuration()));
        taxes.put(readingMater, readingMater.getPrice());
        readingMater.markTaken();
        System.out.println("Rented the book: " + readingMater.getName());
        return readingMater;
    }

    private ReadingMater getReadingMater(ReadingMaterType type) throws BookNotFoundException {
        String kind;
        String name;
        if (readingMaters.get(type) == null) {
            throw new BookNotFoundException();
        }
        if (type == ReadingMaterType.BOOK) {
            kind = BookGenre.values()[Randomizator.getRandNum(0, BookGenre.values().length)].toString();
            name = Constants.BOOK_NAMES[Randomizator.getRandNum(0, Constants.BOOK_NAMES.length)];
        } else {
            kind = SchoolBookTopic.values()[Randomizator.getRandNum(0, SchoolBookTopic.values().length)].toString();
            name = SchoolBookTopic.values()[Randomizator.getRandNum(0, SchoolBookTopic.values().length)].toString();
        }
        if (readingMaters.get(type).get(kind) == null || readingMaters.get(type).get(kind).get(name) == null) {
            throw new BookNotFoundException();
        }
        return readingMaters.get(type).get(kind).get(name).peek();
    }

    public void returnBook(ReadingMater readingMater, Client client) {
        synchronized (lock) {
            readingMaters.get(readingMater.getType()).get(readingMater.getKind()).get(readingMater.getName()).add(readingMater);
        }
        double tax = taxes.get(readingMater);
        receiveTax(tax);
        client.spendMoney(tax);
        System.out.println("Returned " + readingMater.getName() + ", you owe: " + tax + "$");
        readingMater.markReturned();
    }

    private void receiveTax(double tax) {
        this.money += tax;
    }

    public void increaseTax(ReadingMater readingMater) {
        taxes.put(readingMater, taxes.get(readingMater)*1.01);
    }

    public void showAvailability() {
        System.out.println("---------------Library Availability---------------");
        for (Map.Entry<ReadingMaterType, TreeMap<String, HashMap<String, LinkedList<ReadingMater>>>> books : readingMaters.entrySet()) {
            System.out.println(books.getKey() + ":");
            for (Map.Entry<String, HashMap<String, LinkedList<ReadingMater>>> bookKind : books.getValue().entrySet()) {
                System.out.println("\t" + bookKind.getKey() + ":");
                for (Map.Entry<String, LinkedList<ReadingMater>> specificBook : bookKind.getValue().entrySet()) {
                    specificBook.getValue().sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
                    for (ReadingMater book : specificBook.getValue()) {
                        System.out.println("\t\t" + specificBook.getKey());
                    }
                }
            }
        }
        System.out.println("--------------------------------------------------");
    }

}
