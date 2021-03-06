package people;

import main.Hospital;
import util.Randomizator;

public class Patient extends Person {
    private final int age;
    private final Hospital hospital;
    private boolean isVisited;
    private boolean isGivenMeds;
    private int healingPeriod;

    public Patient(Hospital hospital) {
        this.age = Randomizator.getRandNum(1, 100);
        this.hospital = hospital;
        this.isVisited = false;
        this.isGivenMeds = false;
    }

    public boolean isGivenMeds() {
        return isGivenMeds;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public void setGivenMeds(boolean isGivenMeds) {
        this.isGivenMeds = isGivenMeds;
    }

    public void setHealingPeriod() {
        healingPeriod = Randomizator.getRandNum(3, 6);
    }

    public void passADay() {
        healingPeriod--;
    }

    public boolean isReadyForCheckOut() {
        return healingPeriod == 0;
    }

    @Override
    public void run() {
        hospital.addPatient(this);
    }
}
