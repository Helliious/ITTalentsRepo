package main.cases;

import main.citizens.Accuser;
import main.citizens.Defendant;
import main.citizens.Witness;
import main.constants.Constants;
import main.jurists.Judge;
import main.jurists.JudicialAssessor;
import main.jurists.Lawyer;

import java.lang.constant.Constable;

public class CivilCase extends Case {
    private final Accuser accuser;

    public CivilCase(String type,
              Judge judge,
              JudicialAssessor[] judicialAssessors,
              Defendant defendant,
              Witness[] witnesses,
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
        Lawyer[] lawyers = accuser.getLawyers();
        for (int i = 0; i < lawyers.length; i++) {
            if (lawyers[i] != null) {
                lawyers[i].incrementNumberOfCases();
            }
        }
    }

    @Override
    void askQuestionsAccuserSide() {
        Lawyer[] lawyers = accuser.getLawyers();
        for (int i = 0; i < lawyers.length; i++) {
            if (lawyers[i] != null) {
                for (int j = 0; j < Constants.CIVIL_CASE_QUESTIONS_TO_DEFENDANT_BY_ACCUSER; j++) {
                    lawyers[i].askQuestion();
                    System.out.println("Defendant " + getDefendant().getName());
                }
            }
        }
        Witness[] witnesses = getWitnesses();
        for (int i = 0; i < lawyers.length; i++) {
            if (lawyers[i] != null && witnesses != null) {
                for (int j = 0; j < witnesses.length; j++) {
                    if (witnesses[j] != null) {
                        for (int k = 0; k < Constants.CIVIL_CASE_QUESTIONS_TO_WITNESSES_BY_ACCUSER; k++) {
                            lawyers[i].askQuestion();
                            System.out.println("Witness " + witnesses[j].getName());
                        }
                    }
                }
            }
        }
    }
}
