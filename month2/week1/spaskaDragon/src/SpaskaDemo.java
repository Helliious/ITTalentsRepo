import constants.Constants;
import equipment.Equipment;
import creature.*;

import java.util.Random;
import java.util.Scanner;

public class SpaskaDemo {
    public static void main(String[] args) {
        String charName;
        int optionChosen;
        Hero hero;
        Spaska spaska;
        Rabbit rabbit;
        boolean endGame = false;
        Scanner sc = new Scanner(System.in);

        System.out.println("\t\t\tLAMYATA SPASKA GAME\n");
        System.out.print("Choose hero name: ");
        charName = sc.nextLine();
        hero = new Hero(charName, Constants.MAX_HP, 5, 0, 0);
        spaska = new Spaska();
        rabbit = new BasicRabbit();

        //Actual Gameplay
        while (!endGame) {
            System.out.println("GAME OPTIONS:");
            System.out.println("#1 - Go to Tavern and drink beer!");
            System.out.println("#2 - Go to Forest and fight a rabbit!");
            System.out.println("#3 - Go to Creature.Creature.Spaska and kick her ass!");
            System.out.print("Choose what do you wanna do: ");
            do {
                optionChosen = sc.nextInt();
            } while (optionChosen < 1 || optionChosen > 3);
            sc.nextLine();

            if (optionChosen == 1) {
                hero.goToTavern();
                System.out.println("\nAhh got some fresh beers in my tummy!\n");
                hero.showStats();
                System.out.println();
            } else if (optionChosen == 2) {
                int rabbitType = getRandomNumber(0, 3);
                switch (rabbitType) {
                    case 0:
                        rabbit = new BasicRabbit();
                        break;
                    case 1:
                        rabbit = new MidTearRabbit();
                        break;
                    case 2:
                        rabbit = new EpicRabbit();
                        break;
                    default:
                        break;
                }

                while (!rabbit.isDead() && !hero.isDead()) {
                    hero.attack(rabbit);
                    rabbit.attack(hero);
                }

                if (rabbit.isDead()) {
                    char equipItemAnswer;
                    Equipment droppedItem = rabbit.dropItem();
                    hero.showStats();
                    System.out.println("Dropped Item:");
                    droppedItem.showEquipmentStats();

                    do {
                        System.out.print("Do you want to equip the dropped item? (y/n): ");
                        equipItemAnswer = sc.nextLine().charAt(0);
                    } while (equipItemAnswer != 'y' && equipItemAnswer != 'n');

                    if (equipItemAnswer == 'y') {
                        hero.equipItem(droppedItem, droppedItem.getType());
                    }
                }
            } else {
                while (!hero.isDead() && !spaska.isDead()) {
                    hero.attack(spaska);
                    spaska.attack(hero);
                }
            }

            if (hero.isDead()) {
                System.out.println("\nYou just died bro! Go chill a lil', get some beers!\n");
                hero.goToTavern();
            }

            if (spaska.isDead()) {
                endGame = true;
            }
        }

        hero.showStats();
    }

    //method giving random number in range - from min inclusive to max exclusive
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
