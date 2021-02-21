import java.util.Scanner;

// TASK - 5 - B

public class Task12 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter N:");
            n = sc.nextInt();
        } while (n < 1);

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n - i - 1; k++) {
                System.out.print("  ");
            }

            for (int j = 0; j <= 2 * i; j++) {
                System.out.print("# ");
            }

            System.out.println();
        }
    }
}
