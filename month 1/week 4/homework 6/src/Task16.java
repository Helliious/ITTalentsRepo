import java.util.Scanner;

public class Task16 {
    public static void main(String[] args) {
        int firstNumber, secondNumber;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter first number: ");
            firstNumber = sc.nextInt();
            System.out.print("Enter second number: ");
            secondNumber = sc.nextInt();
        } while (firstNumber < 10 || secondNumber < 10 || secondNumber > 5555 || firstNumber > secondNumber);

        printNumbersFromTo(firstNumber, secondNumber);
    }

    static void printNumbersFromTo(int firstNumber, int secondNumber) {
        if (secondNumber < firstNumber) {
            System.out.println();
        } else {
            if (secondNumber % 50 == 0) {
                System.out.print(secondNumber + ", ");
            }

            printNumbersFromTo(firstNumber, --secondNumber);
        }
    }
}
