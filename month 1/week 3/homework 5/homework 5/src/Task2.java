import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        String firstWord, secondWord;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter first word: ");
            firstWord = sc.nextLine();
            System.out.print("Enter second word: ");
            secondWord = sc.nextLine();
        } while ((firstWord.length() < 10 || firstWord.length() > 20) ||
                    (secondWord.length() < 10 || secondWord.length() > 20));

        exchangeSymbols(firstWord, secondWord);
    }

    static void exchangeSymbols(String firstWord, String secondWord) {
        char tempSymbol;
        StringBuilder firstWordMod = new StringBuilder(firstWord);
        StringBuilder secondWordMod = new StringBuilder(secondWord);

        for (int i = 0; i < 5; i++) {
            tempSymbol = firstWordMod.charAt(i);
            firstWordMod.setCharAt(i, secondWordMod.charAt(i));
            secondWordMod.setCharAt(i, tempSymbol);
        }

        firstWord = firstWordMod.toString();
        secondWord = secondWordMod.toString();

        if (firstWord.length() > secondWord.length()) {
            System.out.println(firstWord.length() + " " + firstWord);
        } else if (secondWord.length() > firstWord.length()) {
            System.out.println(secondWord.length() + " " + secondWord);
        } else {
            System.out.println(firstWord.length() + " " + firstWord);
            System.out.println(secondWord.length() + " " + secondWord);
        }
    }
}
