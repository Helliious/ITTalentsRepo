package people;

import main.Hospital;
import util.Randomizator;

public class Doctor extends Person implements IWorker {
    private final Specialization specialization;
    private final Hospital hospital;

    public Doctor(Hospital hospital) {
        int specializationType = Randomizator.getRandNum(0, 3);
        this.specialization = Specialization.values()[specializationType];
        this.hospital = hospital;
    }

    @Override
    public Specialization getSpecialization() {
        return specialization;
    }

    @Override
    public void run() {
        while (true) {
            hospital.giveVisitation(this);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
