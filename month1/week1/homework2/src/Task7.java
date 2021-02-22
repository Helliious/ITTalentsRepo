import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        int n;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter n:");
            n = sc.nextInt();
        } while (n < 1);

        for (int i = 1; i <= n; i++) {
            System.out.print(i * 3);
            if (i != n) {
                System.out.print(',');
            }
        }
    }
}
