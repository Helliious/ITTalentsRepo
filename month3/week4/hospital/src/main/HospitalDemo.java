package main;

import people.Doctor;
import people.Patient;

public class HospitalDemo {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Doctor doctor;
        for (int i = 0; i < 10; i++) {
            doctor = new Doctor();
            hospital.addPatient(new Patient(), doctor, doctor.getSpecialization());
        }

        hospital.showPatients();
    }
}
