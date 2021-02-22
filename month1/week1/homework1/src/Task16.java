import java.util.Scanner;

public class Task16 {
    public static void main(String[] args) {
        int number;
        int firstDigit, secondDigit, thirdDigit;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number:");
        number = sc.nextInt();

        firstDigit = number / 100;
        thirdDigit = number % 10;
        number = number / 10;
        secondDigit = number % 10;

        // In the task the order was wrong, a>b>c means that the digits are in descending order, NOT ascending!
        // And vice versa
        if (firstDigit == secondDigit && secondDigit == thirdDigit) {
            System.out.println("Equal digits!");
        } else if (firstDigit > secondDigit && secondDigit > thirdDigit) {
            System.out.println("Digits are in descending order!");
        } else if (firstDigit < secondDigit && secondDigit < thirdDigit) {
            System.out.println("Digits are in ascending order!");
        }
    }
}
