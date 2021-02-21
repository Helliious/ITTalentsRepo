import java.util.Scanner;

public class Task23 {
    public static void main(String[] args) {
        int n;
        int powOfTwo = 1;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter N:");
            n = sc.nextInt();
        } while (n < 1);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2 * (n - i); j++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {
                if (powOfTwo * 2 >= 10 && powOfTwo * 2 <= 99 && j != i) {
                    System.out.print(powOfTwo + "  ");
                } else if (powOfTwo * 2 >= 100 && j != i) {
                    System.out.print(powOfTwo + " ");
                } else {
                    System.out.print(powOfTwo + "   ");
                }
                powOfTwo *= 2;
            }

            powOfTwo /= 4;

            for (int j = powOfTwo; j > 0; j /= 2)  {
                System.out.print(j + "  ");

                powOfTwo *= 2;
            }

            powOfTwo = 1;

            System.out.println();
        }
    }
}
