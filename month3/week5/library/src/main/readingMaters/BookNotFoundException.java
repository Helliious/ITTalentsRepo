package main.readingMaters;

public class BookNotFoundException extends Exception {
    public BookNotFoundException() {
        super("Book not found!");
    }
}
