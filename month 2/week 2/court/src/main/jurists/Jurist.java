package main.jurists;

import main.util.Validator;

public abstract class Jurist {
    private String name;
    private String position;
    private int yearsOfExperience;
    private int numberOfCases;

    Jurist(String name, String position, int yearsOfExperience, int numberOfCases) {
        if (Validator.isValidString(name)) {
            this.name = name;
        }
        if (Validator.isValidString(position)) {
            this.position = position;
        }
        if (validYearsOfExperience(yearsOfExperience)) {
            this.yearsOfExperience = yearsOfExperience;
        }
        if (validNumberOfCases(numberOfCases)) {
            this.numberOfCases = numberOfCases;
        }
    }

    public String getName() {
        return name;
    }

    public void askQuestion() {
        System.out.print(position + " " + name + " asked a question to ");
    }

    void takeNotes() {
        System.out.println(position + " " + name + " took a note.");

    }

    public int getNumberOfCases() {
        return numberOfCases;
    }

    public void incrementNumberOfCases() {
        numberOfCases++;
    }

    abstract boolean validYearsOfExperience(int yearsOfExperience);
    abstract boolean validNumberOfCases(int numberOfCases);
}
