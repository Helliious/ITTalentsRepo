package main.readingMaters;

import main.constants.Constants;
import main.util.Randomizator;

import java.time.Duration;
import java.time.temporal.TemporalAmount;

public class SchoolBook extends ReadingMater implements IRentable {
    private final String author;
    private final SchoolBookTopic topic;

    public SchoolBook() {
        super(
                SchoolBookTopic.values()[Randomizator.getRandNum(
                        0,
                        SchoolBookTopic.values().length
                )].toString(),
                Constants.PUBLISHING_HOUSES[Randomizator.getRandNum(
                        0,
                        Constants.PUBLISHING_HOUSES.length
                )]
        );
        this.author = Constants.AUTHORS[Randomizator.getRandNum(
                0,
                Constants.AUTHORS.length
        )];
        this.topic = SchoolBookTopic.valueOf(super.getName());
    }

    @Override
    public String getKind() {
        return topic.toString();
    }

    @Override
    public TemporalAmount getRentDuration() {
        return Duration.ofSeconds(5);
    }
}
