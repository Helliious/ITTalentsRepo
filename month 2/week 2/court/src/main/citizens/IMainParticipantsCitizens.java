package main.citizens;

import main.jurists.Lawyer;

public interface IMainParticipantsCitizens extends ICitizen {
    Lawyer[] getLawyers();
    boolean isValidLawyerList(Lawyer[] lawyers);
}
