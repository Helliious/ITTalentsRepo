package main;

import main.cases.Case;
import main.jurists.Jurist;
import main.util.Validator;

public class Court {
    private String name;
    private String address;
    private final Jurist[] jurists;
    private final Case[] cases;

    Court(String name, String address, Jurist[] jurists, Case[] cases) {
        if (Validator.isValidString(name)) {
            this.name = name;
        }
        if (Validator.isValidString(address)) {
            this.address = address;
        }
        this.jurists = jurists;
        this.cases = cases;
    }

    void conductAllCases() {
        for (int i = 0; i < cases.length; i++) {
            if (cases[i] != null) {
                System.out.println("Starting case " + i + ":");
                cases[i].conduct();
            }
        }
    }

    void showJuristsStatistic() {
        sortJurists();
        for (int i = 0; i < jurists.length; i++) {
            if (jurists[i] != null) {
                System.out.println(jurists[i].getName() +
                        " - " + jurists[i].getNumberOfCases());
            }
        }
    }

    void sortJurists() {
        for (int i = 0; i < jurists.length; i++) {
            for (int j = 0; j < jurists.length - i - 1; j++) {
                if (jurists[j].getName().compareTo(jurists[j + 1].getName()) > 0) {
                    Jurist temp = jurists[j];
                    jurists[j] = jurists[j + 1];
                    jurists[j + 1] = temp;
                }
            }
        }
    }
}
