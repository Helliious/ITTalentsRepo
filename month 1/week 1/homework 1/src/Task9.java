import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        byte first, second;
        int lastDigit;
        int result;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number:");
        first = sc.nextByte();
        System.out.println("Enter second number:");
        second = sc.nextByte();

        if (first >= 10 && first <= 99 && second >= 10 && second <= 99) {
            result = first * second;
            lastDigit = result % 10;

            if (lastDigit % 2 == 0) {
                System.out.println("Yes, the digit is even: " + lastDigit);
            } else {
                System.out.println("No, the digit is odd: " + lastDigit);
            }
        } else {
            System.out.println("Wrong input!Numbers must be between 10 and 99!");
        }
    }
}
