import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int n;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter N:");
            n = sc.nextInt();
        } while (n < 1);

        for (int i = 0; i < n; i++) {
            if (i % 2 != 0) {
                System.out.print(" ");
            }

            for (int j = 0; j < n; j++) {
                System.out.print("# ");
            }

            System.out.println();
        }
    }
}
