package main;

import main.cases.Case;
import main.jurists.Jurist;
import main.util.Validator;

import java.util.*;

public class Court {
    private String name;
    private String address;
    private final TreeSet<Jurist> jurists;
    private final HashSet<Case> cases;

    Court(String name, String address, HashSet<Jurist> jurists, HashSet<Case> cases) {
        if (Validator.isValidString(name)) {
            this.name = name;
        }
        if (Validator.isValidString(address)) {
            this.address = address;
        }
        this.jurists = new TreeSet<>((e1, e2) -> e1.getName().compareTo(e2.getName()));
        this.jurists.addAll(jurists);
        this.cases = cases;
    }

    void conductAllCases() {
        int idx = 1;
        for (Iterator<Case> it = cases.iterator(); it.hasNext();) {
            System.out.println("Starting case " + (idx++) + ":");
            it.next().conduct();
        }
    }

    void showJuristsStatistic() {
        for (Iterator<Jurist> it = jurists.iterator(); it.hasNext();) {
            Jurist currJurist = it.next();
            System.out.println(currJurist.getName() +
                    " - " + currJurist.getNumberOfCases());
        }
    }
}
