package people;

import constants.Constants;
import util.Randomizator;

import java.util.Objects;

public abstract class Person extends Thread {
    private static final int[] uniqueDigits = {0,0,0,0,0,0,0};
    private final String name;
    private final String mobileNumber;
    private final Gender gender;

    public Person() {
        this.gender = Randomizator.getRandNum(0, 2) == 0 ? Gender.MALE : Gender.FEMALE;
        if (gender == Gender.MALE) {
            this.name = Constants.MALE_NAMES[Randomizator.getRandNum(
                    0,
                    Constants.MALE_NAMES.length
            )];
        } else {
            this.name = Constants.FEMALE_NAMES[Randomizator.getRandNum(
                    0,
                    Constants.FEMALE_NAMES.length
            )];
        }
        StringBuilder mobile = new StringBuilder();
        mobile.append(Constants.MOBILE_FIRST_DIGITS[Randomizator.getRandNum(
            0,
            Constants.MOBILE_FIRST_DIGITS.length
        )]);
        for (int i = 0; i < uniqueDigits.length; i++) {
            mobile.append(uniqueDigits[i]);
        }
        this.mobileNumber = mobile.toString();
        iterNextMobileNum();
    }

    private void iterNextMobileNum() {
        for (int i = uniqueDigits.length - 1; i >= 0 ; i--) {
            uniqueDigits[i]++;
            if (uniqueDigits[i] == 10) {
                uniqueDigits[i] = 0;
            } else {
                break;
            }
        }
    }

    public String getPersonName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(mobileNumber, person.mobileNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mobileNumber);
    }
}
