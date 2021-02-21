package main.citizens;

public class Witness extends Citizen {
    public Witness(String name, String address, int age) {
        super(name, address, age);
    }

    @Override
    public boolean validAge(int age) {
        return age > 18;
    }
}
