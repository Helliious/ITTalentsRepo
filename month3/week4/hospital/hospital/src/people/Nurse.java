package people;

import main.Hospital;
import util.Randomizator;

public class Nurse extends Person implements IWorker {
    private final int yearsOfExperience;
    private final Specialization department;
    private final Hospital hospital;

    public Nurse(Hospital hospital, Specialization department) {
        this.yearsOfExperience = Randomizator.getRandNum(0, 10);
        this.department = department;
        this.hospital = hospital;
    }

    @Override
    public Specialization getSpecialization() {
        return department;
    }

    @Override
    public void run() {
        while (true) {
            hospital.giveMedicine(this);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
