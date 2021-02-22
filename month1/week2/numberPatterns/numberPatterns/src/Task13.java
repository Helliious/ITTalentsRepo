import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {
        int n;
        int step = 1;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter N:");
            n = sc.nextInt();
        } while (n < 1);

        for (int i = 1; i <= n; i++) {
            for (int j = step; j < n + step; j++) {
                if (j >= 10) {
                    System.out.print(j + " ");
                } else {
                    System.out.print(j + "  ");
                }
            }

            step += n;

            System.out.println();
        }
    }
}
