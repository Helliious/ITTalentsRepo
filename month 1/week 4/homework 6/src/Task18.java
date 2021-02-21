import java.util.Scanner;

public class Task18 {
    public static void main(String[] args) {
        int firstDigit, secondDigit;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter first digit: ");
            firstDigit = sc.nextInt();
            System.out.print("Enter second digit: ");
            secondDigit = sc.nextInt();
        } while (firstDigit < 1 || firstDigit > 9 ||
                secondDigit < 1 || secondDigit > 9);

        printProductTable(1, firstDigit, secondDigit);
    }

    static void printProductTable(int it, int endFirstDigit, int endSecondDigit) {
        if (endFirstDigit == it) {
            printTable(it, 1, endSecondDigit);
        } else {
            printTable(it, 1, endSecondDigit);
            printProductTable(++it, endFirstDigit, endSecondDigit);
        }
    }

    static void printTable(int digit, int it, int endDigit) {
        if (it == endDigit) {
            System.out.println(digit + "*" + it + " = " + (digit * it));
        } else {
            System.out.println(digit + "*" + it + " = " + (digit * it));
            printTable(digit, ++it, endDigit);
        }
    }
}
