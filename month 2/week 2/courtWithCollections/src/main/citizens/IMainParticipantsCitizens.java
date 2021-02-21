package main.citizens;

import main.jurists.Lawyer;

import java.util.HashSet;

public interface IMainParticipantsCitizens extends ICitizen {
    HashSet<Lawyer> getLawyers();
}
