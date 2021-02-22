package main.util;

import main.constants.Constants;
import main.jurists.JudicialAssessor;
import main.jurists.Jurist;
import main.jurists.Lawyer;

import java.util.Random;

public class Randomizator {
    public static int random(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    public static String randomName() {
        int nameIdx;
        if (random(0, 2) == 1) {
            nameIdx = random(0, Constants.MALE_NAMES.length - 1);
            return Constants.MALE_NAMES[nameIdx];
        } else {
            nameIdx = random(0, Constants.FEMALE_NAMES.length - 1);
            return Constants.FEMALE_NAMES[nameIdx];
        }
    }

    public static String randomAddress() {
        int addressIdx = random(0, Constants.ADDRESSES.length - 1);
        return Constants.ADDRESSES[addressIdx];
    }

    public static Lawyer[] randomLawyer(Lawyer[] lawyers, int maxAmount) {
        boolean isPresent;
        int amountOfLawyers = random(1, maxAmount);
        Lawyer[] resultLawyers = new Lawyer[amountOfLawyers];
        int lawyerIdx = random(0, lawyers.length - 1);
        resultLawyers[0] = lawyers[lawyerIdx];
        if (maxAmount > 1) {
            for (int i = 1; i < amountOfLawyers; i++) {
                do {
                    isPresent = false;
                    lawyerIdx = random(0, lawyers.length - 1);
                    for (int j = 0; j < resultLawyers.length; j++) {
                        if (resultLawyers[j] != null) {
                            if (resultLawyers[j].getName().equals(lawyers[lawyerIdx].getName())) {
                                isPresent = true;
                                break;
                            }
                        }
                    }
                } while (isPresent);
                resultLawyers[i] = lawyers[lawyerIdx];
            }
        }
        return resultLawyers;
    }

    public static JudicialAssessor[] randomJudicialAssessor(JudicialAssessor[] judicialAssessors, int maxAmount) {
        boolean isPresent;
        int amountOfJudicialAssessors = random(1, maxAmount);
        JudicialAssessor[] resultJudicialAssessors = new JudicialAssessor[amountOfJudicialAssessors];
        int judicialAssessorIdx = random(0, judicialAssessors.length - 1);
        resultJudicialAssessors[0] = judicialAssessors[judicialAssessorIdx];
        if (maxAmount > 1) {
            for (int i = 1; i < amountOfJudicialAssessors; i++) {
                do {
                    isPresent = false;
                    judicialAssessorIdx = random(0, judicialAssessors.length - 1);
                    for (int j = 0; j < resultJudicialAssessors.length; j++) {
                        if (resultJudicialAssessors[j] != null) {
                            if (resultJudicialAssessors[j].getName().equals(judicialAssessors[judicialAssessorIdx].getName())) {
                                isPresent = true;
                            }
                        }
                    }
                } while (isPresent);
                resultJudicialAssessors[i] = judicialAssessors[judicialAssessorIdx];
            }
        }
        return resultJudicialAssessors;
    }
}
