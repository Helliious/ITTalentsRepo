import java.util.Scanner;

public class Task24 {
    public static void main(String[] args) {
        int number, tempNumber;
        int digit;
        int newNumber = 0;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter number:");
            number = sc.nextInt();
        } while (number < 10 || number > 30000);

        tempNumber = number;

        do {
            digit = tempNumber % 10;
            newNumber = newNumber * 10 + digit;
            tempNumber /= 10;
        } while (tempNumber != 0);

        if (number == newNumber) {
            System.out.println("The number is palindrome!");
        } else {
            System.out.println("The number is NOT palindrome!");
        }
    }
}
