package main.readingMaters;

import main.constants.Constants;
import main.util.Randomizator;

import java.time.LocalDate;

public class Magazine extends ReadingMater {
    private final MagazineCategory magazineCategory;
    private final int number;
    private final LocalDate publishingDate;

    public Magazine() {
        super(
                Constants.MAGAZINE_NAMES[Randomizator.getRandNum(
                        0,
                        Constants.MAGAZINE_NAMES.length
                )],
                Constants.PUBLISHING_HOUSES[Randomizator.getRandNum(
                        0,
                        Constants.PUBLISHING_HOUSES.length
                )]
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
}
