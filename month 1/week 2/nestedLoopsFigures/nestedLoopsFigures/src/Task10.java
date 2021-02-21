import java.util.Scanner;

// TASK - 4 - I

public class Task10 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter N:");
            n = sc.nextInt();
        } while (n < 1);

        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                for (int j = 0; j < n; j++) {
                    System.out.print("# ");
                }
            } else {
                for (int j = 0; j < n; j++) {
                    if (i == j || i == (n - 1) - j || j == 0 || j == n - 1) {
                        System.out.print("# ");
                    } else {
                        System.out.print("  ");
                    }
                }
            }

            System.out.println();
        }
    }
}
