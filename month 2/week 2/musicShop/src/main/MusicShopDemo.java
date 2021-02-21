package main;

import main.instruments.*;

import java.util.Scanner;

public class MusicShopDemo {
    public static void main(String[] args) {
        MusicalInstrument instrument1 = new Strings(
                "Violin",
                150.99,
                5);
        MusicalInstrument instrument2 = new Percussion(
                "Drums",
                550.99,
                1);
        MusicalInstrument instrument3 = new Woodwinds(
                "Flute",
                50.99,
                15);
        MusicalInstrument instrument4 = new Keyboard(
                "Piano",
                1500.99,
                2);
        MusicalInstrument instrument5 = new Electric(
                "Bass Guitar",
                350.99,
                10);

        MusicShop shop = new MusicShop(1500);
        shop.addNewInstrument(instrument1);
        shop.addNewInstrument(instrument2);
        shop.addNewInstrument(instrument3);
        shop.addNewInstrument(instrument4);
        shop.addNewInstrument(instrument5);
        shop.sellInstrument("Violin", 5);

        System.out.println("Enter option for ordering items by price" +
                " (increasing/degreasing):");
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        shop.instrumentsListByPrice(answer);
        System.out.println("\n");
        shop.showShopStats();
    }
}
