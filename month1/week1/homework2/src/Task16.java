import java.util.Scanner;

public class Task16 {
    public static void main(String[] args) {
        int n,m;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter N:");
            n = sc.nextInt();
            System.out.println("Enter M:");
            m = sc.nextInt();
        } while ((n < 10 || n > 5555) || (m < 10 || m > 5555) || (n > m));

        for (int i = m; i >= n; i--) {
            if (i % 50 == 0) {
                System.out.print(i + ", ");
            }
        }
    }
}
