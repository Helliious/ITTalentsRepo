package main.cases;

import main.citizens.Defendant;
import main.citizens.Witness;
import main.constants.Constants;
import main.jurists.Judge;
import main.jurists.JudicialAssessor;
import main.jurists.Prosecutor;

public class CriminalCase extends Case {
    private final Prosecutor accuser;

    public CriminalCase(String type,
                 Judge judge,
                 JudicialAssessor[] judicialAssessors,
                 Defendant defendant,
                 Witness[] witnesses,
                 Prosecutor accuser) {
        super(type, judge, judicialAssessors, defendant, witnesses);
        this.accuser = accuser;
    }

    @Override
    int numberOfAssessors() {
        return Constants.CRIMINAL_CASE_NUM_OF_ASSESSORS;
    }

    @Override
    void incrementAccuserCases() {
        accuser.incrementNumberOfCases();
    }

    @Override
    void askQuestionsAccuserSide() {
        for (int i = 0; i < Constants.CRIMINAL_CASE_QUESTIONS_TO_DEFENDANT_BY_ACCUSER; i++) {
            accuser.askQuestion();
            System.out.println("Defendant " + getDefendant().getName());
        }
        Witness[] witnesses = getWitnesses();
        for (int i = 0; i < witnesses.length; i++) {
            if (witnesses[i] != null) {
                for (int j = 0; j < Constants.CRIMINAL_CASE_QUESTIONS_TO_WITNESSES_BY_ACCUSER; j++) {
                    accuser.askQuestion();
                    System.out.println("Witness " + witnesses[i].getName());
                }
            }
        }
    }
}
