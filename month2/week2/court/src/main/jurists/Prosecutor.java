package main.jurists;

import main.constants.Constants;

public class Prosecutor extends Jurist {
    public Prosecutor(String name, int yearsOfExperience, int numberOfCases) {
        super(name, "Prosecutor", yearsOfExperience, numberOfCases);
    }

    @Override
    boolean validYearsOfExperience(int yearsOfExperience) {
        return yearsOfExperience >= Constants.MIN_YEARS_EXP_PROSECUTOR;
    }

    @Override
    boolean validNumberOfCases(int numberOfCases) {
        return numberOfCases >= 0;
    }
}
