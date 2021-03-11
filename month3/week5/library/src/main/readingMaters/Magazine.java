package main.readingMaters;

import main.Library;
import main.constants.Constants;
import main.util.Randomizator;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.TemporalAmount;

public class Magazine extends ReadingMater {
    private final MagazineCategory magazineCategory;
    private final int number;
    private final LocalDate publishingDate;

    public Magazine(Library library) {
        super(
                Constants.MAGAZINE_NAMES[Randomizator.getRandNum(
                        0,
                        Constants.MAGAZINE_NAMES.length
                )],
                Constants.PUBLISHING_HOUSES[Randomizator.getRandNum(
                        0,
                        Constants.PUBLISHING_HOUSES.length
                )],
                ReadingMaterType.MAGAZINE,
                library
        );
        this.magazineCategory = MagazineCategory.values()[Randomizator.getRandNum(
                0,
                MagazineCategory.values().length
        )];
        this.number = Randomizator.getRandNum(1, 30);
        this.publishingDate = LocalDate.ofYearDay(Randomizator.getRandNum(1950, 2021), Randomizator.getRandNum(1, 366));
    }

    @Override
    public String getKind() {
        return magazineCategory.toString();
    }

    @Override
    public Duration getRentDuration() {
        return null;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
