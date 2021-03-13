package postoffices;

import DBConnector.DBConnector;
import deliverables.Delivery;
import deliverables.Letter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PostOffice {
    private final List<Mailbox> mailboxes;
    private final Warehouse warehouse;
    private final int postmenCount;
    private final TreeMap<Integer, TreeMap<Integer, List<Delivery>>> mailArchive;

    public PostOffice(List<Mailbox> mailboxes, int postmenCount) {
        this.mailboxes = mailboxes;
        this.postmenCount = postmenCount;
        this.warehouse = new Warehouse(postmenCount);
        this.mailArchive = new TreeMap<>();
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

    public void checkMailArchiveMap() {
        if (!mailArchive.containsKey(LocalTime.now().getMinute())) {
            mailArchive.put(LocalTime.now().getMinute(), new TreeMap<>());
        }
        if (!mailArchive.get(LocalTime.now().getMinute()).containsKey(LocalTime.now().getSecond())) {
            mailArchive.get(LocalTime.now().getMinute()).put(LocalTime.now().getSecond(), new LinkedList<>());
        }
    }

    public synchronized void addDeliveryToPostOffice(Delivery delivery) {
        warehouse.addDelivery(delivery);
        checkMailArchiveMap();
        mailArchive.get(LocalTime.now().getMinute()).get(LocalTime.now().getSecond()).add(delivery);
        writeToDB(delivery);
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
            List<Letter> letters = mailbox.getLetters();
            warehouse.addLetters(letters);
            checkMailArchiveMap();
            mailArchive.get(LocalTime.now().getMinute()).get(LocalTime.now().getSecond()).addAll(letters);
            for (Letter l : letters) {
                writeToDB(l);
            }
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

    private void writeToDB(Delivery delivery) {
        String sql = "INSERT INTO mail_archive (" +
                "sender_name, " +
                "receiver_name, " +
                "delivery_address, " +
                "delivery_type, " +
                "send_time) " +
                "VALUES (?, ?, ?, ?, ?)";
        Connection connection = DBConnector.getInstance().getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, delivery.getSender().getFirstName() + " " + delivery.getSender().getLastName());
            ps.setString(2, delivery.getReceiver().getFirstName() + " " + delivery.getReceiver().getLastName());
            ps.setString(3, delivery.getReceiver().getAddress());
            ps.setString(4, delivery.getType().toString());
            ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error connecting to DB. " + e.getMessage());
        }
    }

    public void showArchive() {
        for (Map.Entry<Integer, TreeMap<Integer, List<Delivery>>> e : mailArchive.entrySet()) {
            System.out.println("Minute - " + e.getKey() + ":");
            for (Map.Entry<Integer, List<Delivery>> mailList : e.getValue().entrySet()) {
                System.out.println("\tSecond - " + mailList.getKey() + ":");
                for (Delivery d : mailList.getValue()) {
                    d.showDelivery();
                }
            }
        }
    }
}
