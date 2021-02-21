package main.util;

import main.citizens.Citizen;
import main.jurists.Jurist;
import main.jurists.Lawyer;

public class Validator {
    public static boolean isValidString(String text) {
        return text != null && text.length() > 0;
    }

    public static boolean isValidJuristList(Jurist[] jurists, Jurist newJurist) {
        boolean isValid = true;
        if (jurists != null) {
            for (int i = 0; i < jurists.length; i++) {
                if (jurists[i] != null) {
                    if (jurists[i].getName().equals(newJurist.getName())) {
                        isValid = false;
                        break;
                    }
                }
            }
        }
        return isValid;
    }

    public static boolean isValidAccuserDefendant(Lawyer[] lawyersAccuser,
                                                  Lawyer[] lawyersDefendant) {
        boolean isValid = true;
        for (int i = 0; i < lawyersAccuser.length; i++) {
            if (lawyersAccuser[i] != null) {
                for (int j = 0; j < lawyersDefendant.length; j++) {
                    if (lawyersDefendant[j] != null) {
                        if (lawyersAccuser[i].getName().equals(lawyersDefendant[j].getName())) {
                            isValid = false;
                            break;
                        }
                    }
                }
            }
        }
        return isValid;
    }

    public static boolean isValidCitizenList(Citizen[] citizens, Citizen newCitizen) {
        boolean isValid = true;
        if (citizens != null) {
            for (int i = 0; i < citizens.length; i++) {
                if (citizens[i] != null) {
                    if (citizens[i].getName().equals(newCitizen.getName())) {
                        isValid = false;
                        break;
                    }
                }
            }
        }
        return isValid;
    }
}
