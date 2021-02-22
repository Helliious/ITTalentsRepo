package main;

import main.cases.Case;
import main.cases.CivilCase;
import main.cases.CriminalCase;
import main.citizens.Accuser;
import main.citizens.Defendant;
import main.citizens.Witness;
import main.constants.Constants;
import main.jurists.*;
import main.util.Randomizator;

import java.util.ArrayList;
import java.util.HashSet;

public class CourtDemo {
    public static void main(String[] args) {
        HashSet<Jurist> jurists = new HashSet<>();
        HashSet<Judge> judges = new HashSet<>();
        Judge judge;
        do {
            judge = new Judge(
                    Randomizator.randomName(),
                    Randomizator.random(Constants.MIN_YEARS_EXP_JUDGE,
                            Constants.MAX_YEARS_EXP),
                    Randomizator.random(0, Constants.MAX_CASES)
            );
            judges.add(judge);
            jurists.add(judge);
        } while (judges.size() < 3);

        HashSet<JudicialAssessor> judicialAssessors = new HashSet<>();
        JudicialAssessor judicialAssessor;
        do {
            judicialAssessor = new JudicialAssessor(
                    Randomizator.randomName(),
                    Randomizator.random(0, Constants.MAX_YEARS_EXP),
                    Randomizator.random(0, Constants.MAX_CASES)
            );
            judicialAssessors.add(judicialAssessor);
            jurists.add(judicialAssessor);
        } while (judicialAssessors.size() < 10);

        HashSet<Lawyer> lawyers = new HashSet<>();
        Lawyer lawyer;
        do {
            lawyer = new Lawyer(
                    Randomizator.randomName(),
                    Randomizator.random(0, Constants.MAX_YEARS_EXP),
                    Randomizator.random(Constants.MIN_CASES_LAWYER,
                            Constants.MAX_CASES)
            );
            lawyers.add(lawyer);
            jurists.add(lawyer);
        } while (lawyers.size() < 5);

        HashSet<Prosecutor> prosecutors = new HashSet<>();
        Prosecutor prosecutor;
        do {
            prosecutor = new Prosecutor(
                    Randomizator.randomName(),
                    Randomizator.random(Constants.MIN_YEARS_EXP_PROSECUTOR,
                            Constants.MAX_YEARS_EXP),
                    Randomizator.random(0, Constants.MAX_CASES)
            );
            prosecutors.add(prosecutor);
            jurists.add(prosecutor);
        } while (prosecutors.size() < 2);

        HashSet<Witness> witnesses = new HashSet<>();
        Witness witness;
        do {
            witness = new Witness(
                    Randomizator.randomName(),
                    Randomizator.randomAddress(),
                    Randomizator.random(Constants.MIN_YEARS, Constants.MAX_YEARS)
            );
            witnesses.add(witness);
        } while (witnesses.size() < 10);

        HashSet<Accuser> accusers = new HashSet<>();
        ArrayList<Lawyer> lawyersArr = new ArrayList<>(lawyers);
        do {
            accusers.add(new Accuser(
                    Randomizator.randomName(),
                    Randomizator.randomAddress(),
                    Randomizator.random(Constants.MIN_YEARS, Constants.MAX_YEARS),
                    Randomizator.randomLawyer(lawyersArr, 2)
            ));
        } while (accusers.size() < 5);

        HashSet<Defendant> defendants = new HashSet<>();
        do {
            defendants.add(new Defendant(
                    Randomizator.randomName(),
                    Randomizator.randomAddress(),
                    Randomizator.random(Constants.MIN_YEARS, Constants.MAX_YEARS),
                    Randomizator.randomLawyer(lawyersArr, 2)
            ));
        } while (defendants.size() < 5);

        HashSet<Case> cases = new HashSet<>();
        ArrayList<Accuser> accusersArr = new ArrayList<>(accusers);
        ArrayList<Defendant> defendantsArr = new ArrayList<>(defendants);
        ArrayList<Judge> judgesArr = new ArrayList<>(judges);
        ArrayList<JudicialAssessor> judicialAssessorsArr = new ArrayList<>(judicialAssessors);
        Defendant defendant;
        Accuser accuser;
        do {
            do {
                defendant = defendantsArr.get(Randomizator.random(0, defendants.size() - 1));
                accuser = accusersArr.get(Randomizator.random(0, accusers.size() - 1));
            } while (accuser.getLawyers().equals(defendant.getLawyers()));
            cases.add(new CivilCase(
                    "Civil Case",
                    judgesArr.get(Randomizator.random(0, judges.size() - 1)),
                    Randomizator.randomJudicialAssessor(judicialAssessorsArr, 3),
                    defendant,
                    witnesses,
                    accuser
            ));
        } while (cases.size() < 3);

        ArrayList<Prosecutor> prosecutorsArr = new ArrayList<>(prosecutors);
        do {
            cases.add(new CriminalCase(
                    "Criminal Case",
                    judgesArr.get(Randomizator.random(0, judges.size() - 1)),
                    Randomizator.randomJudicialAssessor(judicialAssessorsArr, 8),
                    defendantsArr.get(Randomizator.random(0, defendants.size() - 1)),
                    witnesses,
                    prosecutorsArr.get(Randomizator.random(0, prosecutors.size() - 1))
            ));
        } while (cases.size() < 6);

        Court court = new Court(
                "Veliko Turnovo",
                "ul. Alexander Malinov",
                jurists,
                cases
        );

        court.showJuristsStatistic();
        court.conductAllCases();
        System.out.println();
        System.out.println();
        court.showJuristsStatistic();
    }
}
