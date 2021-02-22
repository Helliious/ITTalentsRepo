import java.util.Scanner;

public class Task22 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter N:");
            n = sc.nextInt();
        } while (n < 1);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2 * (n - i); j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < i; j++) {
                if ((j + i) >= 10) {
                    System.out.print((j + i) % 10 + " ");
                } else {
                    System.out.print((j + i) + " ");
                }
            }

            for (int j = i - 1; j > 0; j--) {
                if (j + i - 1 >= 10) {
                    System.out.print((j + i - 1) % 10 + " ");
                } else {
                    System.out.print((j + i - 1) + " ");
                }
            }

            System.out.println();
        }
    }
}
