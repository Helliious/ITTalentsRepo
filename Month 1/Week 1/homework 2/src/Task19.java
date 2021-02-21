import java.util.Scanner;

public class Task19 {
    public static void main(String[] args) {
        int number;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter number:");
            number = sc.nextInt();
        } while (number < 10 || number > 99);

        while (number != 1) {
            if (number % 2 == 0) {
                number = (int)(0.5 * number);
            } else {
                number = (3 * number) + 1;
            }

            System.out.print(number + " ");
        }
    }
}
