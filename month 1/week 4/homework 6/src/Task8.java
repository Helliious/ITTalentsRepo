import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        int number;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter number: ");
            number = sc.nextInt();
        } while (number < 1);

        printSequence(1, number, number);
    }

    static void printSequence(int start, int end, int number) {
        if (start >= end) {
            printAmountOfNumber(end, number - 1);
        } else {
            printAmountOfNumber(end, number - 1);
            number += 2;
            printSequence(++start, end, number);
        }
    }

    static void printAmountOfNumber(int amount, int number) {
        if (amount == 1) {
            System.out.println(number);
        } else {
            System.out.print(number);
            printAmountOfNumber(--amount, number);
        }
    }
}
