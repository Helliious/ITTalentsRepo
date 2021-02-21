package main.citizens;

import main.util.Validator;

public abstract class Citizen implements ICitizen {
    private String name;
    private String address;
    private int age;

    Citizen(String name, String address, int age) {
        if (Validator.isValidString(name)) {
            this.name = name;
        }
        if (Validator.isValidString(address)) {
            this.address = address;
        }
        if (validAge(age)) {
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }
}
