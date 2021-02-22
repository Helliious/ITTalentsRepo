import java.util.Scanner;

public class Task21 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter N:");
            n = sc.nextInt();
        } while (n < 1);

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(j + " ");
            }

            for (int j = 0; j < (4 * i) - 2; j++) {
                System.out.print(" ");
            }

            for (int j = n - i; j > 0; j--) {
                if (j == n) {
                    System.out.print("");
                } else {
                    System.out.print(j + " ");
                }
            }

            System.out.println();
        }
    }
}
