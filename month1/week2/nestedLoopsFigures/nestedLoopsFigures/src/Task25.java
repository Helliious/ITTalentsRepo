import java.util.Scanner;

public class Task25 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter N:");
            n = sc.nextInt();
        } while (n < 1);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(".");
            }

            for (int j = 0; j < i; j++) {
                System.out.print(i);
            }

            System.out.println();
        }
    }
}
