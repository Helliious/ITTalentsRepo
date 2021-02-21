package main.citizens;

import main.jurists.Lawyer;

public class Accuser extends Citizen implements IMainParticipantsCitizens {
    private final Lawyer[] lawyers;

    public Accuser(String name, String address, int age, Lawyer[] lawyers) {
        super(name, address, age);
        if (lawyers != null &&
                isValidLawyerList(lawyers)) {
            this.lawyers = lawyers;
        } else {
            this.lawyers = null;
        }
    }

    @Override
    public boolean validAge(int age) {
        return age > 16;
    }

    @Override
    public Lawyer[] getLawyers() {
        return lawyers;
    }

    @Override
    public boolean isValidLawyerList(Lawyer[] lawyers) {
        boolean isValidList = true;
        for (int i = 0; i < lawyers.length; i++) {
            for (int j = i + 1; j < lawyers.length; j++) {
                if (lawyers[i] != null && lawyers[j] != null) {
                    if (lawyers[i].getName().equals(lawyers[j].getName())) {
                        isValidList = false;
                        break;
                    }
                }
            }
        }

        return isValidList;
    }
}
