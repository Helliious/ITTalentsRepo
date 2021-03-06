package people;

import main.Hospital;
import util.Randomizator;

public class Patient extends Person {
    private final int age;
    private boolean isReadyForCheckOut;
    private final Hospital hospital;
    private boolean isVisited;

    public Patient(Hospital hospital) {
        this.age = Randomizator.getRandNum(1, 100);
        this.isReadyForCheckOut = false;
        this.hospital = hospital;
    }

    public void setReadyForCheckOut() {
        isReadyForCheckOut = true;
    }

    public boolean getReadyForCheckOut() {
        return isReadyForCheckOut;
    }

    @Override
    public void run() {
        while (true) {
            hospital.addPatient(this);
        }
    }
}
