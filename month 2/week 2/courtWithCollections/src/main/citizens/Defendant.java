package main.citizens;

import main.jurists.Lawyer;

import java.util.HashSet;

public class Defendant extends Citizen implements IMainParticipantsCitizens {
    private final HashSet<Lawyer> lawyers;

    public Defendant(String name, String address, int age, HashSet<Lawyer> lawyers) {
        super(name, address, age);
        this.lawyers = new HashSet<>(lawyers);
    }

    @Override
    public boolean validAge(int age) {
        return age > 16;
    }

    @Override
    public HashSet<Lawyer> getLawyers() {
        return lawyers;
    }
}
