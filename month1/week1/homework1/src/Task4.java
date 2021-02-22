import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        int first, second;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number:");
        first = sc.nextInt();
        System.out.println("Enter second number:");
        second = sc.nextInt();

        if (first != second) {
            if (first >= second) {
                System.out.println("Numbers in ascending order: " + second + ", " + first);
            } else {
                System.out.println("Numbers in ascending order: " + first + ", " + second);
            }
        } else {
            System.out.println("Wrong input! The numbers must be different!");
        }
    }
}
