import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        String words;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter words: ");
            words = sc.nextLine();
        } while (words.length() < 1);

        countWords(words);
    }

    static void countWords(String words) {
        int countWords = 1;
        int currCharsInWord = 1;
        int maxCharsInWord = 0;

        for (int i = 0; i < words.length(); i++) {
            if (words.charAt(i) == ' ') {
                countWords++;
                if (maxCharsInWord < currCharsInWord) {
                    maxCharsInWord = currCharsInWord;
                }
                currCharsInWord = 0;
            } else {
                currCharsInWord++;
            }
        }

        System.out.print(countWords + " words, the longest has " + maxCharsInWord + " symbols!");
    }
}
