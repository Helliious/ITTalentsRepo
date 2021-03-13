package deliverables;

import persons.Citizen;

public abstract class Delivery {
    private Citizen sender;
    private Citizen receiver;

    Delivery(Citizen sender, Citizen receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    abstract double getTax();
}
