package main;

import people.Doctor;
import people.Nurse;
import people.Patient;
import people.Specialization;


public class HospitalDemo {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Doctor doctor1 = new Doctor(hospital);
        Doctor doctor2 = new Doctor(hospital);
        Doctor doctor3 = new Doctor(hospital);
        Doctor doctor4 = new Doctor(hospital);
        Doctor doctor5 = new Doctor(hospital);
        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addDoctor(doctor3);
        hospital.addDoctor(doctor4);
        hospital.addDoctor(doctor5);

        Patient patient1 = new Patient(hospital);
        Patient patient2 = new Patient(hospital);
        Patient patient3 = new Patient(hospital);
        Patient patient4 = new Patient(hospital);
        Patient patient5 = new Patient(hospital);
        patient1.start();
        patient2.start();
        patient3.start();
        patient4.start();
        patient5.start();

        Nurse nurse1 = new Nurse(hospital, Specialization.CARDIOLOGY);
        Nurse nurse2 = new Nurse(hospital, Specialization.ORTHOPEDICS);
        Nurse nurse3 = new Nurse(hospital, Specialization.VIROLOGY);
        nurse1.start();
        nurse2.start();
        nurse3.start();

        doctor1.start();
        doctor2.start();
        doctor3.start();
        doctor4.start();
        doctor5.start();

    }
}
