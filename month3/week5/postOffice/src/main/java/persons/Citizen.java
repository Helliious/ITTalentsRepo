package persons;

import constants.Constants;
import deliverables.Delivery;
import deliverables.Letter;
import deliverables.Package;
import postoffices.PostOffice;
import util.Randomizator;

import java.util.Random;


public class Citizen extends Person {
    private final String address;
    private final PostOffice postOffice;

    public Citizen(PostOffice postOffice) {
        super();
        this.address = Constants.ADDRESSES[Randomizator.getRandNum(
                0,
                Constants.ADDRESSES.length
        )];
        this.postOffice = postOffice;
    }

    @Override
    public void run() {
        while (true) {
            if (new Random().nextBoolean()) {
                System.out.println("Citizen " + getFirstName() + " " + getLastName() + " send a letter.");
                postOffice.addLetterToMailbox(Randomizator.getRandNum(0, postOffice.getMailboxesCount()),
                        new Letter(this, new Citizen(postOffice)));
            } else {
                Delivery delivery;
                if (new Random().nextBoolean()) {
                    System.out.println("Citizen " + getFirstName() + " " + getLastName() + " send a letter.");
                    delivery = new Letter(this, new Citizen(postOffice));
                } else {
                    System.out.println("Citizen " + getFirstName() + " " + getLastName() + " send a package.");
                    delivery = new Package(this,
                            new Citizen(postOffice),
                            Randomizator.getRandNum(1, 100),
                            Randomizator.getRandNum(1, 100),
                            Randomizator.getRandNum(1, 100),
                            new Random().nextBoolean());
                }
                postOffice.addDeliveryToPostOffice(delivery);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
