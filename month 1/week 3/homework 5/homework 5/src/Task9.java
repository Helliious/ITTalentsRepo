import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        String str;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter string: ");
            str = sc.nextLine();
        } while (str.length() < 1);

        System.out.println("Sum = " + sumNumbers(str));
    }

    static int sumNumbers(String str) {
        int sum = 0;
        int currNumber = 0;
        int countMinuses = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-') {
                countMinuses++;
            }

            if (isNumber(str.charAt(i))) {
                currNumber = 10 * currNumber + (str.charAt(i) - '0');
            }

            if (isLetter(str.charAt(i)) ||
                    (str.charAt(i) == '-' && isNumber(str.charAt(i - 1))) ||
                    (i == str.length() - 1)) {
                if ((countMinuses == 1 && str.charAt(i) != '-') ||
                        (countMinuses > 1 && str.charAt(i) == '-')) {
                    currNumber = -currNumber;
                    countMinuses--;
                }

                if (currNumber != 0) {
                    System.out.println(currNumber);
                }

                sum += currNumber;
                currNumber = 0;
            }
        }

        return sum;
    }

    static boolean isNumber(char symbol) {
        return symbol >= 48 && symbol <= 57;
    }

    static boolean isLetter(char symbol) {
        return (symbol >= 65 && symbol <= 90) ||
                (symbol >= 97 && symbol <= 122);
    }
}
