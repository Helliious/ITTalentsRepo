package deliverables;

import persons.Citizen;

public class Letter extends Delivery {
    Letter(Citizen sender, Citizen receiver) {
        super(sender, receiver);
    }

    @Override
    double getTax() {
        return 0.5;
    }
}
