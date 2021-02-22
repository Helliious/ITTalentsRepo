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
import main.util.Validator;

public class CourtDemo {
    public static void main(String[] args) {
        int juristIdx = 0;
        Jurist[] jurists = new Jurist[20];
        Judge[] judges = new Judge[3];
        Judge judge;
        for (int i = 0; i < judges.length; i++) {
            do {
                judge = new Judge(
                        Randomizator.randomName(),
                        Randomizator.random(Constants.MIN_YEARS_EXP_JUDGE,
                                Constants.MAX_YEARS_EXP),
                        Randomizator.random(0, Constants.MAX_CASES)
                );
            } while (!Validator.isValidJuristList(judges, judge));
            judges[i] = judge;
            jurists[juristIdx++] = judges[i];
        }

        JudicialAssessor[] judicialAssessors = new JudicialAssessor[10];
        JudicialAssessor judicialAssessor;
        for (int i = 0; i < judicialAssessors.length; i++) {
            do {
                judicialAssessor = new JudicialAssessor(
                        Randomizator.randomName(),
                        Randomizator.random(0, Constants.MAX_YEARS_EXP),
                        Randomizator.random(0, Constants.MAX_CASES)
                );
            } while (!Validator.isValidJuristList(judicialAssessors, judicialAssessor));
            judicialAssessors[i] = judicialAssessor;
            jurists[juristIdx++] = judicialAssessors[i];
        }

        Lawyer[] lawyers = new Lawyer[5];
        Lawyer lawyer;
        for (int i = 0; i < lawyers.length; i++) {
            do {
                lawyer = new Lawyer(
                        Randomizator.randomName(),
                        Randomizator.random(0, Constants.MAX_YEARS_EXP),
                        Randomizator.random(Constants.MIN_CASES_LAWYER,
                                Constants.MAX_CASES)
                );
            } while (!Validator.isValidJuristList(lawyers, lawyer));
            lawyers[i] = lawyer;
            jurists[juristIdx++] = lawyers[i];
        }

        Prosecutor[] prosecutors = new Prosecutor[2];
        Prosecutor prosecutor;
        for (int i = 0; i < prosecutors.length; i++) {
            do {
                prosecutor = new Prosecutor(
                        Randomizator.randomName(),
                        Randomizator.random(Constants.MIN_YEARS_EXP_PROSECUTOR,
                                Constants.MAX_YEARS_EXP),
                        Randomizator.random(0, Constants.MAX_CASES)
                );
            } while (!Validator.isValidJuristList(prosecutors, prosecutor));
            prosecutors[i] = prosecutor;
            jurists[juristIdx++] = prosecutors[i];
        }

        Witness[] witnesses = new Witness[10];
        Witness witness;
        for (int i = 0; i < witnesses.length; i++) {
            do {
                witness = new Witness(
                        Randomizator.randomName(),
                        Randomizator.randomAddress(),
                        Randomizator.random(Constants.MIN_YEARS, Constants.MAX_YEARS)
                );
            } while (!Validator.isValidCitizenList(witnesses, witness));
            witnesses[i] = witness;
        }

        Accuser[] accusers = new Accuser[5];
        for (int i = 0; i < accusers.length; i++) {
            accusers[i] = new Accuser(
                    Randomizator.randomName(),
                    Randomizator.randomAddress(),
                    Randomizator.random(Constants.MIN_YEARS, Constants.MAX_YEARS),
                    Randomizator.randomLawyer(lawyers, 2)
            );
        }

        Defendant[] defendants = new Defendant[5];
        for (int i = 0; i < defendants.length; i++) {
            defendants[i] = new Defendant(
                    Randomizator.randomName(),
                    Randomizator.randomAddress(),
                    Randomizator.random(Constants.MIN_YEARS, Constants.MAX_YEARS),
                    Randomizator.randomLawyer(lawyers, 2)
            );
        }

        Case[] cases = new Case[6];
        Defendant defendant;
        Accuser accuser;
        for (int i = 0; i < 3; i++) {
            do {
                defendant = defendants[Randomizator.random(0, defendants.length - 1)];
                accuser = accusers[Randomizator.random(0, accusers.length - 1)];
            } while (!Validator.isValidAccuserDefendant(accuser.getLawyers(),
                    defendant.getLawyers()));
            cases[i] = new CivilCase(
                    "Civil Case",
                    judges[Randomizator.random(0, judges.length - 1)],
                    Randomizator.randomJudicialAssessor(judicialAssessors, 3),
                    defendant,
                    witnesses,
                    accuser
            );
        }

        for (int i = 3; i < 6; i++) {
            cases[i] = new CriminalCase(
                    "Criminal Case",
                    judges[Randomizator.random(0, judges.length - 1)],
                    Randomizator.randomJudicialAssessor(judicialAssessors, 8),
                    defendants[Randomizator.random(0, defendants.length - 1)],
                    witnesses,
                    prosecutors[Randomizator.random(0, prosecutors.length - 1)]
            );
        }

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
