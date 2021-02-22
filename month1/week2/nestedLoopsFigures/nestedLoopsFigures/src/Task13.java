import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter N:");
            n = sc.nextInt();
        } while (n < 1);

        for (int i = 0; i <= n / 2; i++) {
            for (int k = 0; k <= n / 2 - i - 1; k++) {
                System.out.print("  ");
            }

            for (int j = 0; j <= 2 * i; j++) {
                System.out.print("# ");
            }

            System.out.println();
        }

        for (int i = (n / 2) + 1; i < n; i++) {
            for (int k = (n / 2) + 1; k < i; k++) {
                System.out.print("  ");
            }

            System.out.println("I: " + i);

            for (int j = 0; j < (n - (2 * i)) - 1; j++) {
                System.out.print("# ");
            }

            System.out.println();
        }
    }
}
