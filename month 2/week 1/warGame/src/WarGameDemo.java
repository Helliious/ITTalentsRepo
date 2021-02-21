import java.util.Random;

public class WarGameDemo {
    public static void main(String[] args) {
        String[] firstPlayerCards = new String[26];
        String[] secondPlayerCards = new String[26];

        cardsDrawer(firstPlayerCards, secondPlayerCards);
        Player p1 = new Player(firstPlayerCards);
        Player p2 = new Player(secondPlayerCards);

        War gameOfWar = new War(p1, p2);
        gameOfWar.startWar();
    }

    //function randomly splitting 52 cards among the two players
    public static void cardsDrawer(String[] firstPlayerCards, String[] secondPlayerCards) {
        String[] cardsList = {"Two clubs", "Two diamonds", "Two hearts", "Two spades",
                "Three clubs", "Three diamonds", "Three hearts", "Three spades",
                "Four clubs", "Four diamonds", "Four hearts", "Four spades",
                "Five clubs", "Five diamonds", "Five hearts", "Five spades",
                "Six clubs", "Six diamonds", "Six hearts", "Six spades",
                "Seven clubs", "Seven diamonds", "Seven hearts", "Seven spades",
                "Eight clubs", "Eight diamonds", "Eight hearts", "Eight spades",
                "Nine clubs", "Nine diamonds", "Nine hearts", "Nine spades",
                "Ten clubs", "Ten diamonds", "Ten hearts", "Ten spades",
                "Jack clubs", "Jack diamonds", "Jack hearts", "Jack spades",
                "Queen clubs", "Queen diamonds", "Queen hearts", "Queen spades",
                "King clubs", "King diamonds", "King hearts", "King spades",
                "Ace clubs", "Ace diamonds", "Ace hearts", "Ace spades"};
        int firstPlayerCardIdx = 0;
        int secondPlayerCardIdx = 0;
        int firstPlayerNewCardIdx;
        int secondPlayerNewCardIdx;
        boolean hasCard;

        for (int i = 0; i < 26; i++) {
            do {
                hasCard = false;
                //getting different random indexes between 0 and 51
                do {
                    firstPlayerNewCardIdx = getRandomNumberInRange(0, 51);
                    secondPlayerNewCardIdx = getRandomNumberInRange(0, 51);
                } while (firstPlayerNewCardIdx == secondPlayerNewCardIdx);

                //checking if one of the players already has the card with index ...PlayerNewCardIdx
                for (int j = 0; j < firstPlayerCards.length; j++) {
                    if (firstPlayerCards[j] != null && firstPlayerCards[j].equals(cardsList[firstPlayerNewCardIdx])) {
                        hasCard = true;
                        break;
                    }
                }

                for (int j = 0; j < secondPlayerCards.length; j++) {
                    if (secondPlayerCards[j] != null && secondPlayerCards[j].equals(cardsList[secondPlayerNewCardIdx])) {
                        hasCard = true;
                        break;
                    }
                }
            } while (hasCard);

            //assigning the cards to the players
            firstPlayerCards[firstPlayerCardIdx++] = cardsList[firstPlayerNewCardIdx];
            secondPlayerCards[secondPlayerCardIdx++] = cardsList[secondPlayerNewCardIdx];
        }
    }

    //function returning random number between min and max
    public static int getRandomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
