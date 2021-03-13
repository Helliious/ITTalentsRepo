package demo;

import persons.Citizen;
import persons.JuniorPostman;
import persons.Postman;
import postoffices.Mailbox;
import postoffices.PostOffice;

import java.util.LinkedList;

public class PostOfficeDemo {
    public static void main(String[] args) {
        LinkedList<Mailbox> mailboxes = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            mailboxes.add(new Mailbox());
        }
        PostOffice postOffice = new PostOffice(mailboxes, 4);
        Postman postman1 = new Postman(postOffice);
        Postman postman2 = new Postman(postOffice);
        Postman postman3 = new Postman(postOffice);
        Postman postman4 = new Postman(postOffice);
        postman1.start();
        postman2.start();
        postman3.start();
        postman4.start();

        JuniorPostman juniorPostman1 = new JuniorPostman(postOffice);
        JuniorPostman juniorPostman2 = new JuniorPostman(postOffice);
        juniorPostman1.start();
        juniorPostman2.start();

        Citizen citizen1 = new Citizen(postOffice);
        Citizen citizen2 = new Citizen(postOffice);
        Citizen citizen3 = new Citizen(postOffice);
        Citizen citizen4 = new Citizen(postOffice);
        Citizen citizen5 = new Citizen(postOffice);
        citizen1.start();
        citizen2.start();
        citizen3.start();
        citizen4.start();
        citizen5.start();

        Thread data = new Thread(() -> {
            while (true) {
                postOffice.showArchive();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        data.setDaemon(true);
        data.start();
    }
}
