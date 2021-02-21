import java.util.Scanner;

// TASK - 4 - G

public class Task8 {
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

                System.out.println();
            } else {
                for (int j = 0; j < (2 * (n - 1)) - (2 * i); j++) {
                    System.out.print(" ");
                }

                System.out.println("#");
            }
        }
    }
}
