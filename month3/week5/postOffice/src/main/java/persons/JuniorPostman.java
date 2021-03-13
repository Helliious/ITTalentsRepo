package persons;

import util.Randomizator;

public class JuniorPostman extends Person implements IWorker {
    private final int yearsExperience;

    JuniorPostman() {
        super();
        this.yearsExperience = Randomizator.getRandNum(0, 3);
    }

    @Override
    public int gerYearsExperience() {
        return yearsExperience;
    }
}
