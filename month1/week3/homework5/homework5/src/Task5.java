import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        int countSpaces;
        String firstWord, secondWord;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter first word: ");
            firstWord = sc.nextLine();
            System.out.print("Enter second word: ");
            secondWord = sc.nextLine();
        } while (firstWord.length() < 1 || secondWord.length() < 1);

        countSpaces = findNumberOfSpaces(firstWord, secondWord);

        if (countSpaces < 0) {
            System.out.println("The two words do not have matching letters!");
        } else {
            makeCrossWord(firstWord, secondWord, countSpaces);
        }
    }

    static int findNumberOfSpaces(String firstWord, String secondWord) {
        boolean foundPosition = false;
        int countSpaces = 0;

        for (int i = 0; i < firstWord.length(); i++) {
            for (int j = 0; j < secondWord.length(); j++) {
                if (firstWord.charAt(i) == secondWord.charAt(j)) {
                    foundPosition = true;
                    break;
                }
            }

            if (foundPosition) {
                break;
            }

            countSpaces++;
        }

        if (foundPosition) {
            return countSpaces;
        } else {
            return -1;
        }
    }

    static void makeCrossWord(String firstWord, String secondWord, int countSpaces) {
        int countRepeatsFirstWord = 0;

        for (int i = 0; i < secondWord.length(); i++) {
            if (secondWord.charAt(i) == firstWord.charAt(countSpaces) && countRepeatsFirstWord < 1) {
                System.out.println(firstWord);
                countRepeatsFirstWord++;
            } else {
                for (int j = 0; j < countSpaces; j++) {
                    System.out.print(" ");
                }

                System.out.println(secondWord.charAt(i));
            }
        }
    }
}
