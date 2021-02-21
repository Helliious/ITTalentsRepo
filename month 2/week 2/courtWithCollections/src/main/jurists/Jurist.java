package main.jurists;

import main.util.Validator;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jurist jurist = (Jurist) o;
        return yearsOfExperience == jurist.yearsOfExperience &&
                Objects.equals(name, jurist.name) &&
                Objects.equals(position, jurist.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, yearsOfExperience);
    }

    public void incrementNumberOfCases() {
        numberOfCases++;
    }

    abstract boolean validYearsOfExperience(int yearsOfExperience);
    abstract boolean validNumberOfCases(int numberOfCases);
}
