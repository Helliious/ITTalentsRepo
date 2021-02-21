package main;

import main.instruments.MusicalInstrument;

public class MusicShop {
    private static final int AMOUNT_OF_INSTRUMENTS = 10;
    private MusicalInstrument[] musicalInstruments;
    private MusicalInstrument[] soldMusicalInstruments;
    private int nextFreeIdx = 0;
    private double cashDeck;

    MusicShop(double cashDeck) {
        musicalInstruments = new MusicalInstrument[AMOUNT_OF_INSTRUMENTS];
        soldMusicalInstruments = new MusicalInstrument[AMOUNT_OF_INSTRUMENTS];
        if (cashDeck > 0) {
            this.cashDeck = cashDeck;
        }
    }

    MusicShop(MusicalInstrument[] musicalInstruments, double cashDeck) {
        if (musicalInstruments != null) {
            this.musicalInstruments = musicalInstruments;
            nextFreeIdx = musicalInstruments.length;
        }
        if (cashDeck > 0) {
            this.cashDeck = cashDeck;
        }
        soldMusicalInstruments = new MusicalInstrument[AMOUNT_OF_INSTRUMENTS];
    }

    void addNewInstrument(MusicalInstrument musicalInstrument) {
        if (nextFreeIdx < AMOUNT_OF_INSTRUMENTS) {
            this.musicalInstruments[nextFreeIdx++] = musicalInstrument;
        }
    }

    void sellInstrument(String name, int quantity) {
        boolean isPresent = false;
        int itemIdx = 0;
        for (int i = 0; i < musicalInstruments.length; i++) {
            if (musicalInstruments[i].getName().equals(name)) {
                isPresent = true;
                itemIdx = i;
                break;
            }
        }

        if (isPresent) {
            if (musicalInstruments[itemIdx].getQuantity() >= quantity) {
                musicalInstruments[itemIdx].reduceQuantity(quantity);
                cashDeck += musicalInstruments[itemIdx].getPrice() * quantity;
            }
        } else {
            System.out.println("Instrument is not present!");
        }
    }

    void showInstruments() {
        for (int i = 0; i < musicalInstruments.length; i++) {
            if (musicalInstruments[i] != null) {
                musicalInstruments[i].showInstrument();
                System.out.println();
            }
        }
    }

    void showAvailability() {
        for (int i = 0; i < musicalInstruments.length; i++) {
            if (musicalInstruments[i] != null &&
            musicalInstruments[i].getQuantity() > 0) {
                musicalInstruments[i].showInstrument();
                System.out.println();
            }
        }
    }

    void showShopStats() {
        showAvailability();
        System.out.println("Money in cash deck: " + cashDeck + "$");
    }

    void instrumentsListByType() {
        for (int i = 0; i < musicalInstruments.length; i++) {
            for (int j = 0; j < musicalInstruments.length - i - 1; j++) {
                if (musicalInstruments[j] != null && musicalInstruments[j+1] != null) {
                    if (musicalInstruments[j].getType().compareTo(musicalInstruments[j + 1].getType()) > 0) {
                        MusicalInstrument temp = musicalInstruments[j];
                        musicalInstruments[j] = musicalInstruments[j + 1];
                        musicalInstruments[j + 1] = temp;
                    }
                }
            }
        }
        showInstruments();
    }

    void instrumentsListByName() {
        for (int i = 0; i < musicalInstruments.length; i++) {
            for (int j = 0; j < musicalInstruments.length - i - 1; j++) {
                if (musicalInstruments[j] != null && musicalInstruments[j+1] != null) {
                    if (musicalInstruments[j].getName().compareTo(musicalInstruments[j + 1].getName()) > 0) {
                        MusicalInstrument temp = musicalInstruments[j];
                        musicalInstruments[j] = musicalInstruments[j + 1];
                        musicalInstruments[j + 1] = temp;
                    }
                }
            }
        }
        showInstruments();
    }

    void instrumentsListByPrice(String option) {
        for (int i = 0; i < musicalInstruments.length; i++) {
            for (int j = 0; j < musicalInstruments.length - i - 1; j++) {
                if (musicalInstruments[j] != null && musicalInstruments[j+1] != null) {
                    if (option.equals("increasing")) {
                        if (musicalInstruments[j].getPrice() > musicalInstruments[j + 1].getPrice()) {
                            MusicalInstrument temp = musicalInstruments[j];
                            musicalInstruments[j] = musicalInstruments[j + 1];
                            musicalInstruments[j + 1] = temp;
                        }
                    } else {
                        if (musicalInstruments[j].getPrice() < musicalInstruments[j + 1].getPrice()) {
                            MusicalInstrument temp = musicalInstruments[j];
                            musicalInstruments[j] = musicalInstruments[j + 1];
                            musicalInstruments[j + 1] = temp;
                        }
                    }
                }
            }
        }
        showInstruments();
    }
}
