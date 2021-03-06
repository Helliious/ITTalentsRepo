package main;

import people.Doctor;
import people.Patient;
import people.Specialization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hospital {
    HashMap<Specialization, HashMap<Integer, ArrayList<HashMap<Patient, Doctor>>>> patients;

    Hospital() {
        int bedId;
        patients = new HashMap<>();
        patients.put(Specialization.ORTHOPEDICS, new HashMap<>());
        patients.put(Specialization.CARDIOLOGY, new HashMap<>());
        patients.put(Specialization.VIROLOGY, new HashMap<>());
        for (int roomId = 1; roomId <= 10; roomId++) {
            patients.get(Specialization.ORTHOPEDICS).put(roomId, new ArrayList<>());
            patients.get(Specialization.CARDIOLOGY).put(roomId, new ArrayList<>());
            patients.get(Specialization.VIROLOGY).put(roomId, new ArrayList<>());
        }
    }

    public void addPatient(Patient patient, Doctor doctor, Specialization specialization) {
        HashMap<Patient, Doctor> newPatient = new HashMap<>();
        newPatient.put(patient, doctor);
        for (int i = 1; i < 10; i++) {
            if (patients.get(specialization).get(i).size() < 3) {
                patients.get(specialization).get(i).add(newPatient);
                break;
            }
        }
    }

    public void showPatients() {
        for (Map.Entry<Specialization, HashMap<Integer, ArrayList<HashMap<Patient, Doctor>>>> departments : patients.entrySet()) {
            for (Map.Entry<Integer, ArrayList<HashMap<Patient, Doctor>>> rooms : departments.getValue().entrySet()) {
                for (HashMap<Patient, Doctor> roomPatients : rooms.getValue()) {
                    for (Map.Entry<Patient, Doctor> patient : roomPatients.entrySet()) {
                        patient.getKey().showEmployee();
                        patient.getValue().showEmployee();
                    }
                }
            }
        }
    }
}
