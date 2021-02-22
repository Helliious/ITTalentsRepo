import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        int count = 0;
        String sentence;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter sentence: ");
            sentence = sc.nextLine();
        } while (sentence.length() < 1);

//        firstLetterToUpper(sentence);
        firstLetterToUpperSecondVariant(sentence);
    }

    static void firstLetterToUpper(String sentence) {
        for (int i = 0; i < sentence.length(); i++) {
            if (i == 0 || (sentence.charAt(i - 1) == ' ')) {
                System.out.print((char)(sentence.charAt(i) - 32));
            } else {
                System.out.print(sentence.charAt(i));
            }
        }
    }

    static void firstLetterToUpperSecondVariant(String sentence) {
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i].substring(0,1).toUpperCase() +
                            words[i].substring(1) + " ");
        }
    }
}
