package main;

import people.Doctor;
import people.Nurse;
import people.Patient;
import people.Specialization;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Hospital {
    private final HashMap<Specialization, HashMap<Integer, HashMap<Patient, Doctor>>> patients;
    private final Queue<Doctor> doctors;

    Hospital() {
        this.doctors = new LinkedList<>();
        patients = new HashMap<>();
        patients.put(Specialization.ORTHOPEDICS, new HashMap<>());
        patients.put(Specialization.CARDIOLOGY, new HashMap<>());
        patients.put(Specialization.VIROLOGY, new HashMap<>());
        for (int roomId = 1; roomId <= 10; roomId++) {
            patients.get(Specialization.ORTHOPEDICS).put(roomId, new HashMap<>());
            patients.get(Specialization.CARDIOLOGY).put(roomId, new HashMap<>());
            patients.get(Specialization.VIROLOGY).put(roomId, new HashMap<>());
        }
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public synchronized void addPatient(Patient patient) {
        while (doctors.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Doctor doctor = doctors.remove();
        int roomId = 0;
        for (int i = 1; i < 10; i++) {
            if (patients.get(doctor.getSpecialization()).get(i).size() < 3 && !patients.get(doctor.getSpecialization()).get(i).containsKey(patient)) {
                System.out.println("Patient " + patient.getPersonName() + " from gender " + patient.getGender() +
                                    " is accepted with diagnose: " + doctor.getSpecialization() + ". Healing doctor: " + doctor.getPersonName());
                patients.get(doctor.getSpecialization()).get(i).put(patient, doctor);
                roomId = i;
                break;
            }
        }
        while (!patient.getReadyForCheckOut()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        doctors.add(doctor);
        patients.get(doctor.getSpecialization()).get(roomId).remove(patient);
        if (!patients.get(doctor.getSpecialization()).get(roomId).isEmpty()) {
            notifyAll();
        }
    }

    public synchronized void giveMedicine(Nurse nurse) {
        HashMap<Integer, HashMap<Patient, Doctor>> department = patients.get(nurse.getSpecialization());
        for (Map.Entry<Integer, HashMap<Patient, Doctor>> room : department.entrySet()) {
            for (Map.Entry<Patient, Doctor> patient : room.getValue().entrySet()) {
                System.out.println("Nurse " + nurse.getPersonName() + " gave patient " + patient.getKey().getPersonName() +
                                    " in room " + room.getKey() + " from department " + nurse.getSpecialization() + " medicine!");
            }
        }
    }

    public synchronized void giveVisitation(Doctor doctor) {
        HashMap<Integer, HashMap<Patient, Doctor>> department = patients.get(doctor.getSpecialization());
        for (Map.Entry<Integer, HashMap<Patient, Doctor>> room : department.entrySet()) {
            for (Map.Entry<Patient, Doctor> patient : room.getValue().entrySet()) {
                if (patient.getValue() == doctor) {
                    System.out.println("Doctor " + doctor.getPersonName() + " gave visitation to patient " + patient.getKey().getPersonName() +
                            " in room " + room.getKey() + " from department " + doctor.getSpecialization());
                }
            }
        }
    }

    public void showPatients() {
        for (Map.Entry<Specialization, HashMap<Integer, HashMap<Patient, Doctor>>> departments : patients.entrySet()) {
            for (Map.Entry<Integer, HashMap<Patient, Doctor>> rooms : departments.getValue().entrySet()) {
                for (Map.Entry<Patient, Doctor> patient : rooms.getValue().entrySet()) {
                    System.out.println("Patient: " + patient.getKey().getPersonName());
                    System.out.println("Doctor: " + patient.getValue().getPersonName());
                }
            }
        }
    }
}
