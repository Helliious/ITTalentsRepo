package postoffices;

import deliverables.Delivery;
import deliverables.Letter;
import persons.Postman;

import java.util.List;

public class PostOffice {
    private final List<Mailbox> mailboxes;
    private final Warehouse warehouse;
    private final int postmenCount;

    public PostOffice(List<Mailbox> mailboxes, int postmenCount) {
        this.mailboxes = mailboxes;
        this.postmenCount = postmenCount;
        this.warehouse = new Warehouse(postmenCount);
    }

    public synchronized void addLetterToMailbox(int mailboxId, Letter letter) {
        mailboxes.get(mailboxId).addLetter(letter);
        int lettersCount = 0;
        for (Mailbox m : mailboxes) {
            lettersCount += m.getLettersCount();
        }
        if (lettersCount > 50) {
            notifyAll();
        }
    }

    public void addDeliveryToPostOffice(Delivery delivery) {
        warehouse.addDelivery(delivery);
    }

    public int getMailboxesCount() {
        return mailboxes.size();
    }

    public synchronized void loadWarehouse() {
        while (warehouse.getDeliveriesCount() > 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Mailbox mailbox = getNonEmptyMailbox();
        if (mailbox != null) {
            warehouse.addLetters(mailbox.getLetters());
        }
        if (warehouse.getDeliveriesCount() > 20) {
            notifyAll();
        }
    }

    public synchronized List<Delivery> makeADelivery() {
        while (warehouse.getDeliveriesCount() <= 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        List<Delivery> delivery = warehouse.getDelivery();
        if (warehouse.getDeliveriesCount() <= 20) {
            notifyAll();
        }
        return delivery;
    }

    private Mailbox getNonEmptyMailbox() {
        for (Mailbox m : mailboxes) {
            if (!m.isEmpty()) {
                return m;
            }
        }
        return null;
    }

    public void showStock() {
        System.out.println("------------Post Office------------");
        for (Mailbox m : mailboxes) {
            System.out.println("--------Mailbox " + m.getMailboxId() + "--------");
            m.showLetters();
        }
        System.out.println("--------Warehouse stock--------");
        warehouse.showStock();
        System.out.println("------------------------------------");
    }
}
