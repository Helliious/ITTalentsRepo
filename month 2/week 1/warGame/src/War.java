public class War {
    private final Player firstPlayer;
    private final Player secondPlayer;
    private static final String[] cardsPowerChart = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
                                                     "Nine", "Ten", "Jack", "Queen", "King", "Ace"};

    War(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    //function checking which of the given cards is stronger
    public int checkCards(String firstCard, String secondCard) {
        String[] firstCardWords = firstCard.split(" ");
        String[] secondCardWords = secondCard.split(" ");
        int firstCardIdx = 0;
        int secondCardIdx = 0;

        //checking if the cards are equal -> return value 0
        if (firstCardWords[0].equals(secondCardWords[0])) {
            return 0;
        }

        for (int i = 0; i < cardsPowerChart.length; i++) {
            if (firstCardWords[0].equals(cardsPowerChart[i])) {
                firstCardIdx = i;
            }
            if (secondCardWords[0].equals(cardsPowerChart[i])) {
                secondCardIdx = i;
            }
        }

        //first card > second card -> 1
        //first card < second card -> -1
        if (firstCardIdx > secondCardIdx) {
            return 1;
        } else {
            return -1;
        }
    }

    //checking the winner after a normal battle
    public void currBattleWinner(int battleWinner, int amountOfCards) {
        if (battleWinner == 1) {
            if (amountOfCards > 1) {
                firstPlayer.gainAmountOfCards(amountOfCards);
            } else {
                firstPlayer.gainACard();
            }
            System.out.println("Round won by player 1!\n");
        } else {
            if (amountOfCards > 1) {
                secondPlayer.gainAmountOfCards(amountOfCards);
            } else {
                secondPlayer.gainACard();
            }
            System.out.println("Round won by player 2!\n");
        }
    }

    public void startWar() {
        String firstPlayerCard;
        String secondPlayerCard;
        int battleWinner;
        int amountOfCards = 1;
        boolean endGame = false;

        while (!endGame) {
            firstPlayerCard = firstPlayer.getCard();
            secondPlayerCard = secondPlayer.getCard();
            System.out.printf("First player card: %-30s | Second player card: %s\n", firstPlayerCard, secondPlayerCard);
            battleWinner = checkCards(firstPlayerCard, secondPlayerCard);

            //equal cards were shown -> starting War
            if (battleWinner == 0) {
                System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t\t\tWAR!\n");
                //Drawing 3 cards each player
                firstPlayerCard = firstPlayer.getCardAfter(2);
                secondPlayerCard = secondPlayer.getCardAfter(2);
                System.out.printf("First player Third card in War: %-17s | Second player Third card in War: %s\n",
                        firstPlayerCard, secondPlayerCard);
                battleWinner = checkCards(firstPlayerCard, secondPlayerCard);
                amountOfCards += 3;

                //check if on third card we are at war again
                if (battleWinner == 0) {
                    firstPlayerCard = firstPlayer.getCard();
                    secondPlayerCard = secondPlayer.getCard();
                    while (firstPlayerCard.equals(secondPlayerCard)) {
                        amountOfCards++;
                        firstPlayerCard = firstPlayer.getCard();
                        secondPlayerCard = secondPlayer.getCard();
                    }

                    battleWinner = checkCards(firstPlayerCard, secondPlayerCard);
                }
            }
            currBattleWinner(battleWinner, amountOfCards);

            //terminating game after one of the players finished his deck
            if (firstPlayer.endOfCards() || secondPlayer.endOfCards()) {
                endGame = true;
            }
        }

        //evaluating the winner
        if (firstPlayer.getCountOfCards() > secondPlayer.getCountOfCards()) {
            System.out.println("First Player Wins!");
        } else {
            System.out.println("Second Player Wins!");
        }
    }
}
