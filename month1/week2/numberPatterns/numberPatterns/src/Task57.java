import java.util.Scanner;

public class Task57 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter N:");
            n = sc.nextInt();
        } while (n < 1);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }

            for (int j = i - 1; j > 0; j--) {
                System.out.print(j + " ");
            }

            System.out.println();
        }

        for (int i = n - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }

            for (int j = i - 1; j > 0; j--) {
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }
}
