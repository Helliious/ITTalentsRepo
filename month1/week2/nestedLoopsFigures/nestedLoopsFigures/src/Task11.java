import java.util.Scanner;

// Task - 5 - A

public class Task11 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter N:");
            n = sc.nextInt();
        } while (n < 1);

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < i; k++) {
                System.out.print("  ");
            }

            for (int j = 0; j < ((2 * n) - (2 * i)) - 1; j++) {
                System.out.print("# ");
            }

            System.out.println();
        }
    }
}
