package persons;

import postoffices.PostOffice;
import util.Randomizator;

public class JuniorPostman extends Person implements IWorker {
    private final int yearsExperience;
    private final PostOffice postOffice;

    public JuniorPostman(PostOffice postOffice) {
        this.yearsExperience = Randomizator.getRandNum(0, 3);
        this.postOffice = postOffice;
    }

    @Override
    public int gerYearsExperience() {
        return yearsExperience;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Junior postman " + getFirstName() + " " + getLastName() + " started collecting mail...");
            postOffice.loadWarehouse();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Junior postman " + getFirstName() + " " + getLastName() + " loaded warehouse");
        }
    }
}
