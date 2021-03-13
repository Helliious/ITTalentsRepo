package deliverables;

import persons.Citizen;

public abstract class Delivery {
    private final Citizen sender;
    private final Citizen receiver;

    Delivery(Citizen sender, Citizen receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    public Citizen getSender() {
        return sender;
    }

    public Citizen getReceiver() {
        return receiver;
    }

    abstract double getTax();
    public abstract DeliveryType getType();
    public abstract int getDeliveryTime();

    public void showDelivery() {
        System.out.println("\t\tDelivery type: " + getType());
        System.out.println("\t\tFrom: " + sender.getFirstName() + " " + sender.getLastName());
        System.out.println("\t\tTo: " + receiver.getFirstName() + " " + receiver.getLastName());
        System.out.println("\t\tPrice: " + getTax() + "$");
    }
}
