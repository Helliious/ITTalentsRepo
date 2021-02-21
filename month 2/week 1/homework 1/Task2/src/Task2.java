public class Task2 {
    public static void main(String[] args) {
        GSM firstPhone = new GSM();
        GSM secondPhone = new GSM();

        firstPhone.model = "Nokia X";
        firstPhone.insertSimCard("0882265463");

        secondPhone.model = "Samsung S3";
        secondPhone.insertSimCard("0882265221");
        firstPhone.removeSimCard();

        if (!firstPhone.call(secondPhone, 38)) {
            return;
        }

        if (!secondPhone.call(firstPhone, 23)) {
            return;
        }

        firstPhone.printForTheLastOutgoingCall();
        System.out.println();
        firstPhone.printForTheLastIncomingCall();

        System.out.println("\nPrice for all outgoing calls for number " + firstPhone.simMobileNumber +
                                ": " + firstPhone.getSumForCall());
        System.out.println("Price for all outgoing calls for number " + secondPhone.simMobileNumber +
                                ": " + secondPhone.getSumForCall());
    }
}
