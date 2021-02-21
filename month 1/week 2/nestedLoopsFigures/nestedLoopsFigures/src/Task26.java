import java.util.Scanner;

public class Task26 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter N:");
            n = sc.nextInt();
        } while (n < 1);

        for (int i = 1; i <=n; i++) {
            if (i == 1) {
                for (int j = 1; j <= 10; j++) {
                    System.out.print(j + " ");
                }
            } else {
                for (int j = i; j <= 10 * i; j += i) {
                    System.out.print(j + " ");
                }
            }

            System.out.println();
        }
    }
}
