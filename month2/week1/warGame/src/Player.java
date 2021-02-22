public class Player {
    private static final int NUMBER_OF_CARDS = 26;
    private final String[] cards;
    private int cardIdx;
    private int countOfCards;

    //constructor for Player, setting initial values and adding cards
    Player(String[] cards) {
        cardIdx = 0;
        countOfCards = NUMBER_OF_CARDS;
        this.cards = new String[NUMBER_OF_CARDS];
        for (int i = 0; i < cards.length; i++) {
            this.cards[i] = cards[i];
        }
    }

    //drawing a card from your deck
    public String getCard() {
        return cards[cardIdx++];
    }

    //drawing a specific amount of cards when you are in War
    public String getCardAfter(int numOfCards) {
        cardIdx += numOfCards;
        //Check if we are able to draw 3 cards -> if not we draw the last one we have
        if (cardIdx > NUMBER_OF_CARDS - 1) {
            cardIdx = NUMBER_OF_CARDS - 1;
        }
        return cards[cardIdx++];
    }

    //Checking if we have reached the end of our deck
    public boolean endOfCards() {
        return cardIdx == NUMBER_OF_CARDS;
    }

    //incrementing amount of cards we have after a normal win
    public void gainACard() {
        countOfCards++;
    }

    //incrementing amount of cards we have after a win in a war
    public void gainAmountOfCards(int amountOfCards) {
        countOfCards += amountOfCards;
    }

    //getter for the amount of cards we have
    public int getCountOfCards() {
        return countOfCards;
    }

    public void showCards() {
        for (int i = 0; i < cards.length; i++) {
            System.out.println(cards[i]);
        }
    }
}
