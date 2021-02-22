import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        int number;
        int result = 0;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter number:");
            number = sc.nextInt();
        } while (number < 1);

        for (int i = 1; i <= number; i++) {
            result += i;
        }

        System.out.println("The result is: " + result);
    }
}
