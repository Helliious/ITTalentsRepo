package people;

import util.Randomizator;

public class Nurse extends Person {
    private final int yearsOfExperience;

    Nurse() {
        this.yearsOfExperience = Randomizator.getRandNum(0, 10);
    }
}
