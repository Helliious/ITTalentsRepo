package main.jurists;

import main.util.Randomizator;

public class JudicialAssessor extends Jurist {
    public JudicialAssessor(String name, int yearsOfExperience, int numberOfCases) {
        super(name, "Judicial Assessor", yearsOfExperience, numberOfCases);
    }

    public boolean isGuilty() {
        return Randomizator.random(0, 2) == 1;
    }

    @Override
    boolean validYearsOfExperience(int yearsOfExperience) {
        return yearsOfExperience >= 0;
    }

    @Override
    boolean validNumberOfCases(int numberOfCases) {
        return numberOfCases >= 0;
    }
}
