package main.util;

import main.constants.Constants;
import main.jurists.JudicialAssessor;
import main.jurists.Lawyer;

import java.util.ArrayList;
import java.util.HashSet;
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

    public static HashSet<Lawyer> randomLawyer(ArrayList<Lawyer> lawyers, int maxAmount) {
        int amountOfLawyers = random(1, maxAmount);
        HashSet<Lawyer> resultLawyers = new HashSet<>();
        int lawyerIdx = random(0, lawyers.size() - 1);
        resultLawyers.add(lawyers.get(lawyerIdx));
        if (maxAmount > 1) {
            do {
                lawyerIdx = random(0, lawyers.size() - 1);
                resultLawyers.add(lawyers.get(lawyerIdx));
            } while (resultLawyers.size() < amountOfLawyers);
        }
        return resultLawyers;
    }

    public static HashSet<JudicialAssessor> randomJudicialAssessor(ArrayList<JudicialAssessor> judicialAssessors, int maxAmount) {
        int amountOfJudicialAssessors = random(1, maxAmount);
        HashSet<JudicialAssessor> resultJudicialAssessors = new HashSet<>();
        int judicialAssessorIdx = random(0, judicialAssessors.size() - 1);
        resultJudicialAssessors.add(judicialAssessors.get(judicialAssessorIdx));
        if (maxAmount > 1) {
            do {
                judicialAssessorIdx = random(0, judicialAssessors.size() - 1);
                resultJudicialAssessors.add(judicialAssessors.get(judicialAssessorIdx));
            } while (resultJudicialAssessors.size() < amountOfJudicialAssessors);
        }
        return resultJudicialAssessors;
    }
}
