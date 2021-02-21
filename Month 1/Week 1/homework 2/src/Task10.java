import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        int number;
        boolean notPrime = false;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter number:");
            number = sc.nextInt();
        } while (number < 1);

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                notPrime = true;
                break;
            }
        }

        if (notPrime) {
            System.out.println("Number " + number + " is NOT prime!");
        } else {
            System.out.println("Number " + number + " is prime!");
        }
    }
}
