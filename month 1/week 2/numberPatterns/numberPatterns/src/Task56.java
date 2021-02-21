import java.util.Scanner;

public class Task56 {
    public static void main(String[] args) {
        int n;
        int numCount = 1;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter N:");
            n = sc.nextInt();
        } while (n < 1);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= numCount; j++) {
                System.out.print(j + " ");
            }

            numCount += 2;
            System.out.println();
        }

        numCount -= 4;

        for (int i = numCount; i > 0; i--) {
            for (int j = 1; j <= numCount; j++) {
                System.out.print(j + " ");
            }

            numCount -= 2;
            System.out.println();
        }
    }
}
