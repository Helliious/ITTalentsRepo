package people;

import util.Randomizator;

public class Doctor extends Person {
    private final Specialization specialization;

    public Doctor() {
        int specializationType = Randomizator.getRandNum(0, 3);
        this.specialization = Specialization.values()[specializationType];
    }

    public Specialization getSpecialization() {
        return specialization;
    }
}
