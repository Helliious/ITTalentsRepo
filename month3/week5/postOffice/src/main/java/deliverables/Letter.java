package deliverables;

import persons.Citizen;

public class Letter extends Delivery {
    public Letter(Citizen sender, Citizen receiver) {
        super(sender, receiver);
    }

    @Override
    double getTax() {
        return 0.5;
    }

    @Override
    public DeliveryType getType() {
        return DeliveryType.LETTER;
    }

    @Override
    public int getDeliveryTime() {
        return 1000;
    }
}
