package main.jurists;

import main.constants.Constants;
import main.util.Randomizator;

public class Judge extends Jurist {
    public Judge(String name, int yearsOfExperience, int numberOfCases) {
        super(name, "Judge", yearsOfExperience, numberOfCases);
    }

    public int calcSentence() {
        return Randomizator.random(3, 40);
    }

    @Override
    boolean validYearsOfExperience(int yearsOfExperience) {
        return yearsOfExperience >= Constants.MIN_YEARS_EXP_JUDGE;
    }

    @Override
    boolean validNumberOfCases(int numberOfCases) {
        return numberOfCases >= 0;
    }
}
