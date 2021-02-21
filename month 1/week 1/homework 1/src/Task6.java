import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        int first, second, third, temp;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number:");
        first = sc.nextInt();
        System.out.println("Enter second number:");
        second = sc.nextInt();
        System.out.println("Enter third number:");
        third = sc.nextInt();

        if (first != second && first != third && second != third) {
            temp = first;
            first = second;
            second = third;
            third = temp;

            System.out.println("New first number: " + first + ", New second number: " + second + ", New second number: " + third);
        } else {
            System.out.println("Wrong input! The numbers must be different!");
        }
    }
}
