import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        int first, second, temp;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number:");
        first = sc.nextInt();
        System.out.println("Enter second number:");
        second = sc.nextInt();

        if (first != second) {
            temp = first;
            first = second;
            second = temp;

            System.out.println("New first number: " + first + ", New second number: " + second);
        } else {
            System.out.println("Wrong input! The numbers must be different!");
        }
    }
}
