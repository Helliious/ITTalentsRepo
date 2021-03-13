package persons;

import util.Randomizator;

public class Postman extends Person implements IWorker {
    private final int yearsExperience;

    Postman() {
        super();
        this.yearsExperience = Randomizator.getRandNum(3, 10);
    }

    @Override
    public int gerYearsExperience() {
        return yearsExperience;
    }
}
