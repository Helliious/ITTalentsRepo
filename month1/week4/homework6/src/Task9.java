import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        int firstNumber, secondNumber;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter first number: ");
            firstNumber = sc.nextInt();
            System.out.print("Enter second number: ");
            secondNumber = sc.nextInt();
        } while (firstNumber > secondNumber || firstNumber < 0 || secondNumber < 1);

        printNumFromTo(firstNumber, secondNumber, 0);
    }

    static void printNumFromTo(int firstNumber, int secondNumber, int sum) {
        if (firstNumber >= secondNumber || sum > 200) {
            if (firstNumber % 3 == 0 && sum <= 200) {
                System.out.println("skip 3");
            }
        } else {
            if (firstNumber % 3 == 0) {
                System.out.print("skip 3, ");
            } else {
                System.out.print((firstNumber * firstNumber) + ", ");
                sum += (firstNumber * firstNumber);
            }

            printNumFromTo(++firstNumber, secondNumber, sum);
        }
    }
}
