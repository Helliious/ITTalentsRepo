package main.cases;

import main.citizens.Accuser;
import main.citizens.Defendant;
import main.citizens.Witness;
import main.constants.Constants;
import main.jurists.Judge;
import main.jurists.JudicialAssessor;
import main.jurists.Lawyer;

import java.util.HashSet;
import java.util.Iterator;

public class CivilCase extends Case {
    private final Accuser accuser;

    public CivilCase(String type,
              Judge judge,
              HashSet<JudicialAssessor> judicialAssessors,
              Defendant defendant,
              HashSet<Witness> witnesses,
              Accuser accuser) {
        super(type, judge, judicialAssessors, defendant, witnesses);
        this.accuser = accuser;
    }

    @Override
    int numberOfAssessors() {
        return Constants.CIVIL_CASE_NUM_OF_ASSESSORS;
    }

    @Override
    void incrementAccuserCases() {
        HashSet<Lawyer> lawyers = accuser.getLawyers();
        for (Iterator<Lawyer> it = lawyers.iterator(); it.hasNext();) {
            it.next().incrementNumberOfCases();
        }
    }

    @Override
    void askQuestionsAccuserSide() {
        HashSet<Lawyer> lawyers = accuser.getLawyers();
        for (Iterator<Lawyer> it = lawyers.iterator(); it.hasNext();) {
            Lawyer lawyer = it.next();
            for (int j = 0; j < Constants.CIVIL_CASE_QUESTIONS_TO_DEFENDANT_BY_ACCUSER; j++) {
                lawyer.askQuestion();
                System.out.println("Defendant " + getDefendant().getName());
            }
        }

        for (Iterator<Lawyer> itLaw = lawyers.iterator(); itLaw.hasNext();) {
            Lawyer lawyer = itLaw.next();
            for (Iterator<Witness> it = getWitnesses().iterator(); it.hasNext();) {
                Witness witness = it.next();
                for (int k = 0; k < Constants.CIVIL_CASE_QUESTIONS_TO_WITNESSES_BY_ACCUSER; k++) {
                    lawyer.askQuestion();
                    System.out.println("Witness " + witness.getName());
                }
            }
        }
    }
}
