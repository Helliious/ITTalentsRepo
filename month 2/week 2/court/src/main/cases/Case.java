package main.cases;

import main.citizens.Defendant;
import main.citizens.Witness;
import main.constants.Constants;
import main.jurists.Judge;
import main.jurists.JudicialAssessor;
import main.jurists.Lawyer;
import main.util.Validator;

public abstract class Case {
    private String type;
    private final Judge judge;
    private JudicialAssessor[] judicialAssessors;
    private final Defendant defendant;
    private final Witness[] witnesses;

    Case(String type,
         Judge judge,
         JudicialAssessor[] judicialAssessors,
         Defendant defendant,
         Witness[] witnesses) {
        if (Validator.isValidString(type)) {
            this.type = type;
        }
        this.judge = judge;
        if (numberOfAssessors() >= judicialAssessors.length &&
            isValidListAssessors(judicialAssessors)) {
            this.judicialAssessors = judicialAssessors;
        }
        this.defendant = defendant;
        if (witnesses != null &&
                isValidListWitnesses(witnesses)) {
            this.witnesses = witnesses;
        } else {
            this.witnesses = null;
        }
    }

    boolean isValidListAssessors(JudicialAssessor[] judicialAssessors) {
        boolean isValid = true;
        for (int i = 0; i < judicialAssessors.length; i++) {
            for (int j = i + 1; j < judicialAssessors.length; j++) {
                if (judicialAssessors[i] != null && judicialAssessors[j] != null) {
                    if (judicialAssessors[i].getName().equals(judicialAssessors[j].getName())) {
                        isValid = false;
                        break;
                    }
                }
            }
        }
        return isValid;
    }

    boolean isValidListWitnesses(Witness[] witnesses) {
        boolean isValid = true;
        for (int i = 0; i < witnesses.length; i++) {
            for (int j = i + 1; j < witnesses.length; j++) {
                if (witnesses[i] != null && witnesses[j] != null) {
                    if (witnesses[i].getName().equals(witnesses[j].getName())) {
                        isValid = false;
                        break;
                    }
                }
            }
        }
        return isValid;
    }

    public void conduct() {
        incrementJuristsCases();
        askQuestionsAccuserSide();
        askQuestionsDefendantSide();
        boolean isGuilty = assessorsDecision();
        if (isGuilty) {
            System.out.println("The Judge decided to sentence " +
                    defendant.getName() + " to " + judgeCalcSentence() + " years!");
        } else {
            System.out.println(defendant.getName() + " is innocent!");
        }
    }

    void incrementJuristsCases() {
        judge.incrementNumberOfCases();
        for (int i = 0; i < judicialAssessors.length; i++) {
            if (judicialAssessors[i] != null) {
                judicialAssessors[i].incrementNumberOfCases();
            }
        }
        Lawyer[] lawyers = defendant.getLawyers();
        for (int i = 0; i < lawyers.length; i++) {
            if (lawyers[i] != null) {
                lawyers[i].incrementNumberOfCases();
            }
        }
        incrementAccuserCases();
    }

    void askQuestionsDefendantSide() {
        Lawyer[] lawyers = defendant.getLawyers();
        for (int i = 0; i < lawyers.length; i++) {
            if (lawyers[i] != null && witnesses != null) {
                for (int j = 0; j < witnesses.length; j++) {
                    if (witnesses[j] != null) {
                        for (int k = 0; k < Constants.QUESTIONS_TO_WITNESSES_BY_DEFENCE; k++) {
                            lawyers[i].askQuestion();
                            System.out.println("Witness " + witnesses[j].getName());
                        }
                    }
                }
            }
        }
    }

    boolean assessorsDecision() {
        int countGuilty = 0;
        int countInnocent = 0;
        System.out.println("Judicial Assessors deciding " +
                defendant.getName() + "'s fate...");
        for (int i = 0; i < judicialAssessors.length; i++) {
            if (judicialAssessors[i] != null) {
                if (judicialAssessors[i].isGuilty()) {
                    countGuilty++;
                } else {
                    countInnocent++;
                }
            }
        }

        return countGuilty > countInnocent;
    }

    int judgeCalcSentence() {
        return judge.calcSentence();
    }

    Defendant getDefendant() {
        return defendant;
    }

    Witness[] getWitnesses() {
        return witnesses;
    }

    abstract int numberOfAssessors();
    abstract void incrementAccuserCases();
    abstract void askQuestionsAccuserSide();
}
