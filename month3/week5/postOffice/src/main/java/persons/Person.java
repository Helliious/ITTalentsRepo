package persons;

import constants.Constants;
import util.Randomizator;

public abstract class Person extends Thread {
    private final String firstName;
    private final String lastName;

    Person() {
        this.firstName = Constants.FIRST_NAMES[Randomizator.getRandNum(
                0,
                Constants.FIRST_NAMES.length
        )];
        this.lastName = Constants.LAST_NAMES[Randomizator.getRandNum(
                0,
                Constants.LAST_NAMES.length
        )];
    }
}
