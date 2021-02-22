package main.cases;

import main.citizens.Defendant;
import main.citizens.Witness;
import main.constants.Constants;
import main.jurists.Judge;
import main.jurists.JudicialAssessor;
import main.jurists.Lawyer;
import main.util.Validator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public abstract class Case {
    private String type;
    private final Judge judge;
    private final HashSet<JudicialAssessor> judicialAssessors;
    private final Defendant defendant;
    private final HashSet<Witness> witnesses;

    Case(String type,
         Judge judge,
         HashSet<JudicialAssessor> judicialAssessors,
         Defendant defendant,
         HashSet<Witness> witnesses) {
        if (Validator.isValidString(type)) {
            this.type = type;
        }
        this.judge = judge;
        this.judicialAssessors = new HashSet<>();
        if (numberOfAssessors() >= judicialAssessors.size()) {
            this.judicialAssessors.addAll(judicialAssessors);
        }
        this.defendant = defendant;
        this.witnesses = new HashSet<>();
        this.witnesses.addAll(witnesses);
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
        for (Iterator<JudicialAssessor> it = judicialAssessors.iterator(); it.hasNext();) {
             it.next().incrementNumberOfCases();
        }
        for (Iterator<Lawyer> it = defendant.getLawyers().iterator(); it.hasNext();) {
            it.next().incrementNumberOfCases();
        }
        incrementAccuserCases();
    }

    void askQuestionsDefendantSide() {
        for (Iterator<Lawyer> itLaw = defendant.getLawyers().iterator(); itLaw.hasNext();) {
            Lawyer lawyer = itLaw.next();
            for (Iterator<Witness> itWit = witnesses.iterator(); itWit.hasNext();) {
                Witness witness = itWit.next();
                for (int k = 0; k < Constants.QUESTIONS_TO_WITNESSES_BY_DEFENCE; k++) {
                    lawyer.askQuestion();
                    System.out.println("Witness " + witness.getName());
                }
            }
        }
    }

    boolean assessorsDecision() {
        int countGuilty = 0;
        int countInnocent = 0;
        System.out.println("Judicial Assessors deciding " +
                defendant.getName() + "'s fate...");
        for (Iterator<JudicialAssessor> it = judicialAssessors.iterator(); it.hasNext();) {
            if (it.next().isGuilty()) {
                countGuilty++;
            } else {
                countInnocent++;
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

    HashSet<Witness> getWitnesses() {
        return witnesses;
    }

    abstract int numberOfAssessors();
    abstract void incrementAccuserCases();
    abstract void askQuestionsAccuserSide();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Case aCase = (Case) o;
        return Objects.equals(type, aCase.type) &&
                Objects.equals(judge, aCase.judge) &&
                Objects.equals(defendant, aCase.defendant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, judge, defendant);
    }
}
