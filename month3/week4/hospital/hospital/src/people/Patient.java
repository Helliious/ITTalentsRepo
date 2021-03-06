package people;

import util.Randomizator;

public class Patient extends Person {
    private final int age;

    public Patient() {
        this.age = Randomizator.getRandNum(1, 100);
    }
}
