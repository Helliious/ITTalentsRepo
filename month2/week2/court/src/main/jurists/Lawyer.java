package main.jurists;

import main.constants.Constants;

public class Lawyer extends Jurist {
    public Lawyer(String name, int yearsOfExperience, int numberOfCases) {
        super(name, "Lawyer", yearsOfExperience, numberOfCases);
    }

    @Override
    boolean validYearsOfExperience(int yearsOfExperience) {
        return yearsOfExperience >= 0;
    }

    @Override
    boolean validNumberOfCases(int numberOfCases) {
        return numberOfCases >= Constants.MIN_CASES_LAWYER;
    }
}
