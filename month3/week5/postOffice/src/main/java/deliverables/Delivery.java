package deliverables;

import persons.Citizen;

public abstract class Delivery {
    private final Citizen sender;
    private final Citizen receiver;

    Delivery(Citizen sender, Citizen receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    abstract double getTax();
    public abstract DeliveryType getType();
    public abstract int getDeliveryTime();

    public void showDelivery() {
        System.out.println("Delivery type: " + getType());
        System.out.println("From: " + sender.getFirstName() + " " + sender.getLastName());
        System.out.println("To: " + receiver.getFirstName() + " " + receiver.getLastName());
        System.out.println("Price: " + getTax() + "$");
    }
}
