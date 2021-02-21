public class GSM {
    String model;
    boolean hasSimCard;
    String simMobileNumber;
    int outgoingCallsDuration = 0;
    Call lastIncomingCall = new Call();
    Call lastOutgoingCall = new Call();

    void insertSimCard(String simMobileNumber) {
        if (simMobileNumber.charAt(0) == '0' &&
                simMobileNumber.charAt(1) == '8' &&
                simMobileNumber.length() == 10) {
            this.simMobileNumber = simMobileNumber;
            this.hasSimCard = true;
        } else {
            System.out.println("Invalid number!");
        }
    }

    void removeSimCard() {
        this.simMobileNumber = null;
        this.hasSimCard = false;
    }

    boolean call(GSM receiver, int duration) {
        if (duration < 1) {
            System.out.println("Invalid duration!");
            return false;
        }

        if (!this.hasSimCard || !receiver.hasSimCard) {
            System.out.println("No sim card!");
            return false;
        }

        if (this.simMobileNumber.equals(receiver.simMobileNumber)) {
            System.out.println("Same number!");
            return false;
        }

        lastOutgoingCall.caller = this.simMobileNumber;
        lastOutgoingCall.receiver = receiver.simMobileNumber;
        lastOutgoingCall.duration = duration;

        receiver.lastIncomingCall.caller = this.simMobileNumber;
        receiver.lastIncomingCall.receiver = receiver.simMobileNumber;
        receiver.lastIncomingCall.duration = duration;

        outgoingCallsDuration += duration;
        return true;
    }

    double getSumForCall() {
        return outgoingCallsDuration * Call.priceForAMinute;
    }

    void printForTheLastOutgoingCall() {
        if (lastOutgoingCall.caller != null) {
            System.out.println("Caller: " + lastOutgoingCall.caller);
            System.out.println("Receiver: " + lastOutgoingCall.receiver);
            System.out.println("Duration: " + lastOutgoingCall.duration);
        } else {
            System.out.println("No outgoing calls!");
        }
    }

    void printForTheLastIncomingCall() {
        if (lastIncomingCall.caller != null) {
            System.out.println("Caller: " + lastIncomingCall.caller);
            System.out.println("Receiver: " + lastIncomingCall.receiver);
            System.out.println("Duration: " + lastIncomingCall.duration);
        } else {
            System.out.println("No incoming calls!");
        }
    }
}
