package main.readingMaters;

import main.Library;
import main.constants.Constants;
import main.util.Randomizator;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.TemporalAmount;

public class Book extends ReadingMater {
    private final String author;
    private final LocalDate publishingDate;
    private final BookGenre bookGenre;

    public Book(Library library) {
        super(
                Constants.BOOK_NAMES[1],
                Constants.PUBLISHING_HOUSES[Randomizator.getRandNum(
                        0,
                        Constants.PUBLISHING_HOUSES.length
                )],
                ReadingMaterType.BOOK,
                library
        );
        this.author = Constants.AUTHORS[Randomizator.getRandNum(
                0,
                Constants.AUTHORS.length
        )];
        this.publishingDate = LocalDate.ofYearDay(Randomizator.getRandNum(1900, 2021), Randomizator.getRandNum(1, 366));
        this.bookGenre = BookGenre.values()[Randomizator.getRandNum(
                0,
                BookGenre.values().length
        )];
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    @Override
    public String getKind() {
        return bookGenre.toString();
    }

    @Override
    public Duration getRentDuration() {
        return Duration.ofSeconds(3);
    }

    @Override
    public double getPrice() {
        return 2.0;
    }
}
