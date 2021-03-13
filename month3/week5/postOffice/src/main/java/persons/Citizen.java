package persons;

import constants.Constants;
import util.Randomizator;

public class Citizen extends Person {
    private final String address;

    Citizen() {
        super();
        this.address = Constants.ADDRESSES[Randomizator.getRandNum(
                0,
                Constants.ADDRESSES.length
        )];
    }
}
