package persons;

import deliverables.Delivery;
import postoffices.PostOffice;
import util.Randomizator;

import java.util.List;

public class Postman extends Person implements IWorker {
    private final int yearsExperience;
    private final PostOffice postOffice;

    public Postman(PostOffice postOffice) {
        this.yearsExperience = Randomizator.getRandNum(3, 10);
        this.postOffice = postOffice;
    }

    @Override
    public int gerYearsExperience() {
        return yearsExperience;
    }

    @Override
    public void run() {
        while (true) {
            List<Delivery> deliveries = postOffice.makeADelivery();
            for (Delivery d : deliveries) {
                try {
                    Thread.sleep(d.getDeliveryTime());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Postman " + getFirstName() + " " + getLastName() + " made a delivery!");
        }
    }
}
