import java.util.Scanner;

public class Task15 {
    public static void main(String[] args) {
        int sum = 0;
        int n;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter N:");
            n = sc.nextInt();
        } while (n < 1);

        do {
            sum += n;
            n--;
        } while (n > 0);

        System.out.println("Sum is: " + sum);
    }
}
